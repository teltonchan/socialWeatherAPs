package util;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class RestAPI {
    private final String urlString = "http://teltonchan-001-site1.smarterasp.net/socialweather.ashx";
        
        private static String convertStreamToUTF8String(InputStream stream) throws IOException {
            String result = "";
            StringBuilder sb = new StringBuilder();
            try {
                InputStreamReader reader = new InputStreamReader(stream, "UTF-8");
                char[] buffer = new char[4096];
                int readedChars = 0;
                while (readedChars != -1) {
                    readedChars = reader.read(buffer);
                    if (readedChars > 0)
                        sb.append(buffer, 0, readedChars);
                }
                result = sb.toString();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            return result;
        }
        
        
        private String load(String contents) throws IOException {
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setRequestMethod("POST");
            conn.setConnectTimeout(60000);
            conn.setDoOutput(true);
            conn.setDoInput(true);
            OutputStreamWriter w = new OutputStreamWriter(conn.getOutputStream());
            w.write(contents);
            w.flush();
            InputStream istream = conn.getInputStream();
            String result = convertStreamToUTF8String(istream);
            return result;
        }
        
        
        private Object mapObject(Object o) {
            Object finalValue = null;
            if (o.getClass() == String.class) {
                finalValue = o;
            }
            else if (Number.class.isInstance(o)) {
                finalValue = String.valueOf(o);
            } else if (Date.class.isInstance(o)) {
                SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss", new Locale("en", "USA"));
                finalValue = sdf.format((Date)o);
            }
            else if (Collection.class.isInstance(o)) {
                Collection<?> col = (Collection<?>) o;
                JSONArray jarray = new JSONArray();
                for (Object item : col) {
                    jarray.put(mapObject(item));
                }
                finalValue = jarray;
            } else {
                Map<String, Object> map = new HashMap<String, Object>();
                Method[] methods = o.getClass().getMethods();
                for (Method method : methods) {
                    if (method.getDeclaringClass() == o.getClass()
                        && method.getModifiers() == Modifier.PUBLIC
                        && method.getName().startsWith("get")) {
                        String key = method.getName().substring(3);
                        try {
                            Object obj = method.invoke(o, null);
                            Object value = mapObject(obj);
                            map.put(key, value);
                            finalValue = new JSONObject(map);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
                
            }
            return finalValue;
        }
        
        public JSONObject CreatePersonUser(String LastName,String FirstName,String Address,String City,String State,String ZIP,String name,String email,String password,String q1,String q2,String q3) throws Exception {
            JSONObject result = null;
            JSONObject o = new JSONObject();
            JSONObject p = new JSONObject();
            o.put("interface","RestAPI");
            o.put("method", "CreatePersonUser");
            p.put("LastName",mapObject(LastName));
            p.put("FirstName",mapObject(FirstName));
            p.put("Address",mapObject(Address));
            p.put("City",mapObject(City));
            p.put("State",mapObject(State));
            p.put("ZIP",mapObject(ZIP));
            p.put("name",mapObject(name));
            p.put("email",mapObject(email));
            p.put("password",mapObject(password));
            p.put("q1",mapObject(q1));
            p.put("q2",mapObject(q2));
            p.put("q3",mapObject(q3));
            o.put("parameters", p);
            String s = o.toString();
            String r = load(s);
            result = new JSONObject(r);
            return result;
        }
        
        public JSONObject GetUserDetails(String userID) throws Exception {
            JSONObject result = null;
            JSONObject o = new JSONObject();
            JSONObject p = new JSONObject();
            o.put("interface","RestAPI");
            o.put("method", "GetUserDetails");
            p.put("userID",mapObject(userID));
            o.put("parameters", p);
            String s = o.toString();
            String r = load(s);
            result = new JSONObject(r);
            return result;
        }
        
        public JSONObject UserAuthentication(String email,String pass) throws Exception {
            JSONObject result = null;
            JSONObject o = new JSONObject();
            JSONObject p = new JSONObject();
            o.put("interface","RestAPI");
            o.put("method", "UserAuthentication");
            p.put("email",mapObject(email));
            p.put("pass",mapObject(pass));
            o.put("parameters", p);
            String s = o.toString();
            String r = load(s);
            result = new JSONObject(r);
            return result;
        }
        
        public JSONObject CreatePost(String personID,String msg,String zip,String city) throws Exception {
            JSONObject result = null;
            JSONObject o = new JSONObject();
            JSONObject p = new JSONObject();
            o.put("interface","RestAPI");
            o.put("method", "CreatePost");
            p.put("personID",mapObject(personID));
            p.put("msg",mapObject(msg));
            p.put("zip",mapObject(zip));
            p.put("city",mapObject(city));
            o.put("parameters", p);
            String s = o.toString();
            String r = load(s);
            result = new JSONObject(r);
            return result;
        }
        
        public JSONObject GetPost(String gid) throws Exception {
            JSONObject result = null;
            JSONObject o = new JSONObject();
            JSONObject p = new JSONObject();
            o.put("interface","RestAPI");
            o.put("method", "GetPost");
            p.put("gid",mapObject(gid));
            o.put("parameters", p);
            String s = o.toString();
            String r = load(s);
            result = new JSONObject(r);
            return result;
        }
        
    }

package com.hoperun.hormachine.util;



import com.google.gson.Gson;

public class ParseUtils
{
    
    public static <T> T parse(String json, Class<T> cla)
        throws Exception
    {
        try
        {
            
            if (json != null)
            {
//            	//只有这样 Gson 在解析的时候 @Expose 才会生效。
//            	GsonBuilder builder = new GsonBuilder();  
//            	builder.excludeFieldsWithoutExposeAnnotation();  
//            	Gson gson = builder.create();
                Gson gson = new Gson();
                T response = (T)gson.fromJson(json, cla);
                return response;
            }
        }
        catch (Exception e)
        { e.printStackTrace();
            // TODO: handle exception
           // throw new MIPException(ExceptionConst.EXCEPTION, e.toString());
        }
        return null;
    }
}
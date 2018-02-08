package com.sjie.Behind.Net_V;

import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.SelectionModel;
import com.intellij.openapi.project.Project;
import com.sjie.BaseBuilder;

public class Volleys extends BaseBuilder {
    @Override
    public void build(SelectionModel selectionModel, Project project, Document document,int select) {
        final int start = selectionModel.getSelectionStart();
        final int end = selectionModel.getSelectionEnd();
        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                String builder;
                switch (select){
                    case 0:
                        builder=pget();
                        break;
                    case 1:
                        builder=ppost();
                        break;
                    default:
                        builder="";
                        break;

                }
                document.replaceString(start, end, builder);
            }
        };
        WriteCommandAction.runWriteCommandAction(project, runnable);
        selectionModel.removeSelection();
    }

    private String pget() {
        return "//可以换成stringRequest/jsonarrayRequest\n"
                + " String url = \"https://suggest.taobao.com/sug?area=etao&code=utf-8&q=%E5%8D%AB%E8%A1%A3\";\n"
                + " JsonObjectRequest jsonRequest = new JsonObjectRequest\n"
                + "         (Request.Method.GET, url, (String) null, new Response.Listener<JSONObject>() {\n"
                + "             @Override\n"
                + "             public void onResponse(JSONObject jsonObject) {\n"
                + "                     String ss=jsonObject.toString();\n"
                + "                 Toast.makeText(MainActivity.this, ss, Toast.LENGTH_SHORT).show();\n"
                + "                 /*try {\n"
                + "                     jsonObject = jsonObject.getJSONObject(\"args\");\n"
                + "                     String site = jsonObject.getString(\"site\");\n"
                + "                     String  network = jsonObject.getString(\"network\");\n"
                + "                     System.out.println(\"Site: \" + site + \"\nNetwork: \" + network);\n"
                + "                 } catch (JSONException e) {\n"
                + "                     e.printStackTrace();\n"
                + "                 }*/\n"
                + "             }\n"
                + "         }, new Response.ErrorListener() {\n"
                + "             @Override\n"
                + "             public void onErrorResponse(VolleyError volleyError) {\n"
                + "                 Toast.makeText(MainActivity.this, volleyError.getMessage(), Toast.LENGTH_SHORT).show();\n"

                + "             }\n"
                + "         });\n"
                + " jsonRequest.setRetryPolicy(new DefaultRetryPolicy(300*1000, 1, 1.0f));\n"
                + " Volley.newRequestQueue(this).add(jsonRequest);\n";


    }
    private String ppost() {
        return "Map<String, String> map = new HashMap<String, String>();\n"
                +"map.put(\"name1\", \"value1\");\n"
                +"map.put(\"name2\", \"value2\");\n"
                +"JSONObject jsonObject = new JSONObject(params);\n"
                +"JsonRequest<JSONObject> jsonRequest = new JsonObjectRequest(Method.POST, httpurl, jsonObject,\n"
                +"        new Response.Listener<JSONObject>() {\n"
                +"            @Override\n"
                +"            public void onResponse(JSONObject response) {\n"
                +"                Log.d(TAG, \"response -> \" + response.toString());\n"
                +"            }\n"
                +"        }, new Response.ErrorListener() {\n"
                +"    @Override\n"
                +"    public void onErrorResponse(VolleyError error) {\n"
                +"        Log.e(TAG, error.getMessage(), error);\n"
                +"    }\n"
                +"});\n"
                +"jsonRequest.setRetryPolicy(new DefaultRetryPolicy(300*1000, 1, 1.0f));\n"
                +"Volley.newRequestQueue(this).add(jsonRequest);\n";
    }

}

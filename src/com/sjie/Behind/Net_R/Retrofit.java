package com.sjie.Behind.Net_R;

import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.SelectionModel;
import com.intellij.openapi.project.Project;
import com.sjie.BaseBuilder;

public class Retrofit extends BaseBuilder{
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
                        builder=HttpServer();
                        break;
                    case 1:
                        builder=sendbody();
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
    private String HttpServer(){
        return "public interface HttpService {\n"
               +"    @GET(\"/group/{id}/users\")\n"
               +"    List<User> groupList(@Path(\"id\") int groupId);\n"
                +"\n"
               +"    @GET(\"/group/{id}/users\")\n"
               +"    List<User> groupList(@Path(\"id\") int groupId, @Query(\"sort\") String sort);\n"
                +"\n"
               +"    @GET(\"/group/{id}/users\")\n"
               +"    List<User> groupList(@Path(\"id\") int groupId, @QueryMap Map<String, String> options);\n"
                +"\n"
               +"    @POST(\"/users/new\")\n"
               +"    void createUser(@Body User user, Callback<User> cb);//Callback参数下面讲解\n"
                +"\n"
               +"    @Headers(\"Cache-Control: max-age=640000\")\n"
               +"    @GET(\"/widget/list\")\n"
               +"    List<Widget> widgetList();\n"
                +"\n"
               +"    @Multipart//多部分数组形式提交体\n"
               +"    @POST(\"Ashx/Snapshot.ashx\")\n"
               +"    Call<Result> uploadPictures(@Part() MultipartBody.Part  part);\n"
                +"\n"
               +"    @Multipart//多部分列表形式提交体\n"
               +"    @POST(\"AppHandler_Test.ashx\")\n"
               +"    Call<ResponseBody> modifyy(@PartMap Map<String, RequestBody> map, @Part List<MultipartBody.Part> parts);\n"
                +"\n"
               +"    @FormUrlEncoded//表单提交\n"
               +"    @POST(\"/user/edit\")\n"
               +"    Call<ResponseBody> updateUser(@Field(\"first_name\") String first, @Field(\"last_name\") String last);\n"
                +"\n"
               +"    @Headers({\"Content-type:application/json,\"Accept: application/json\"})\n"
               +"    @POST(\"/api/v1/trade/HasAccount.json\")\n"
               +"    Call<BaseResponse> createCommit(@Body RequestBody route);\n"
               +"}\n";
    }
    private String sendbody(){
       return "private  List<MultipartBody.Part> FilesToMultipartBodyParts(List<File> files) {\n"
               +"    List<MultipartBody.Part> parts = new ArrayList<>(files.size());\n"
               +"    for (File file : files) {\n"
               +"        RequestBody requestBody = RequestBody.create(MediaType.parse(\"image/png\"), file);\n"
               +"        MultipartBody.Part part = MultipartBody.Part.createFormData(\"multipartFiles\", file.getName(), requestBody);\n"
               +"        parts.add(part);\n"
               +"    }\n"
               +"    return parts;\n"
               +"}\n"
               +"/*private  MultipartBody.Part [] FilesToMultipartBodyParts(List<String> pathList) {\n"
               +"    MultipartBody.Part[] parts = new MultipartBody.Part[pathList.size()];\n"
               +"    for (int i = 0; i < pathList.size(); i++) {\n"
               +"        RequestBody requestBody = RequestBody.create(MediaType.parse(\"multipart/form-data\"), new File(pathList.get(i)));\n"
               +"        part[i] = MultipartBody.Part.createFormData(\"2018/1/25\", new File(pathList.get(i)).getName(), requestBody);\n"
               +"    }\n"
               +"    return parts;\n"
               +"}*/\n"
               +"//json提交\n"
                +"/*String strEntity = gson.toJson(paramsMap);\n"
                +"RequestBody body = RequestBody.create(okhttp3.MediaType.parse(\"application/json;charset=UTF-8\"),strEntity);*/\n";
    }

}

package com.sjie.Function;

import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.SelectionModel;
import com.intellij.openapi.project.Project;
import com.sjie.BaseBuilder;

public class Functions extends BaseBuilder {
    @Override
    public void build(SelectionModel selectionModel, Project project, Document document, int select) {
        final int start = selectionModel.getSelectionStart();
        final int end = selectionModel.getSelectionEnd();
        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                String builder;
                switch (select){
                    case 0:
                        builder=filedownload();
                        break;
                    case 1:
                        builder=Imagedownload();
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
    private String filedownload(){
        return "public void updatafile(final String filename){\n"
                +"    new Thread(new Runnable() {\n"
                +"        @Override\n"
                +"        public void run() {\n"
                +"            String fileName = \"op262gyhz.bkt.clouddn.com\"; //域名\n"
                +"            String key=filename;                        //服务器端文件名\n"
                +"            String urlStr = \"http://\" + fileName + \"/\" + key+\"?attname=&v=\"+String.valueOf(System.currentTimeMillis());\n"
                +"            File filepath=new File(LoadData.filepath+\"/\"+filename);\n"
                +"            try {\n"
                +"                URL url = new URL(urlStr);\n"
                +"                HttpURLConnection conn = (HttpURLConnection) url.openConnection();\n"
                +"                conn.setConnectTimeout(5 * 1000);\n"
                +"                conn.setRequestMethod(\"GET\");\n"
                +"                  conn.setRequestProperty(\"Connection\", \"Keep-Alive\");\n"
                +"                  conn.setRequestProperty(\"Content-Type\", \"*/*\");\n"
                +"                  conn.setRequestProperty(\"User-Agent\", \"Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)\");\n"
                +"                float totalLen = conn.getContentLength();  // 文件大小 byte\n"
                +"                // 读取网络流到inStream中\n"
                +"                InputStream inStream = conn.getInputStream();\n"
                +"                // 定入二进制到文件\n"
                +"                if (filepath.exists()){\n"
                +"                    filepath.delete();\n"
                +"                }\n"
                +"                // 在文件系统中根据路径创建一个新的空文件\n"
                +"                filepath.createNewFile();\n"
                +"                OutputStream outStream = new FileOutputStream(filepath);\n"
                +"                byte[] buff = new byte[1024];\n"
                +"                int hasRead;\n"
                +"                float nowLen = 0.0f;\n"
                +"                while ((hasRead = inStream.read(buff)) != -1) {\n"
                +"                    outStream.write(buff, 0, hasRead);\n"
                +"                    nowLen +=(float) hasRead;\n"
                +"                    // 显示下载进度\n"
                +"                    DecimalFormat df = new DecimalFormat(\"#.00\");\n"
                +"                    float precent=(float)(nowLen/totalLen)*100.0f;\n"
                +"                    int value = (int) precent;\n"
                +"                    Message msg = new Message();\n"
                +"                    msg.what = 4;\n"
                +"                    Bundle bundle = new Bundle();\n"
                +"                    bundle.putInt(\"value\", value);\n"
                +"                    bundle.putString(\"precent\", ss);\n"
                +"                    msg.setData(bundle);\n"
                +"                    handler.sendMessage(msg);\n"
                +"                }\n"
                +"                outStream.close();\n"
                +"                inStream.close();\n"
                +"                Message msg=new Message();\n"
                +"                msg.what=5;\n"
                +"                msg.obj=filepath.toString();\n"
                +"                handler.sendMessage(msg);\n"
                +"                //conn.disconnect();\n"
                +"            } catch (IOException e) {\n"
                +"                e.printStackTrace();\n"
                +"            }\n"
                +"        }\n"
                +"    }).start();\n"
                +"}\n"
                +"Handler handler = new Handler() {\n"
                +"    @Override\n"
                +"    public void handleMessage(Message msg) {\n"
                +"        switch (msg.what) {\n"
                +"            case 4:\n"
                +"                break;\n"
                +"            case 5:\n"
                +"                Toast.makeText(mainActivity, \"下载完成！\", Toast.LENGTH_SHORT).show();\n"
                +"                break;\n"
                +"            default:\n"
                +"                break;\n"
                +"        }\n"
                +"        super.handleMessage(msg);\n"
                +"    }\n"
                +"};\n";

    }
    private String Imagedownload(){
        return "Handler handler = new Handler() {\n"
                +"    @Override\n"
                +"    public void handleMessage(Message msg) {\n"
                +"        switch (msg.what) {\n"
                +"            case 1:\n"
                +"                imageView.setImageBitmap(bitmap);\n"
                +"                break;\n"
                +"            default:\n"
                +"                break;\n"
                +"        }\n"
                +"        super.handleMessage(msg);\n"
                +"    }\n"
                +"};\n"
                +"protected Bitmap bitmap;\n"
                +"private void getBitmap(final String url) {\n"
                +"    Thread thread = new Thread() {\n"
                +"        @Override\n"
                +"        public void run() {\n"
                +"            URL myFileURL;\n"
                +"            try {\n"
                +"                myFileURL = new URL(url);\n"
                +"                HttpURLConnection conn = (HttpURLConnection) myFileURL\n"
                +"                        .openConnection();\n"
                +"                conn.setConnectTimeout(6 * 1000);\n"
                +"                conn.setDoInput(true);\n"
                +"                conn.setUseCaches(false);\n"
                +"                InputStream is = conn.getInputStream();\n"
                +"                bitmap = BitmapFactory.decodeStream(is);\n"
                +"                is.close();\n"
                +"                Message message = handler.obtainMessage();\n"
                +"                message.what = 1;\n"
                +"                handler.sendMessage(message);\n"
                +"            } catch (Exception e) {\n"
                +"                e.printStackTrace();\n"
                +"            }\n"
                +"            super.run();\n"
                +"        }\n"
                +"    };\n"
                +"    thread.start();\n"
                +"    thread = null;\n"
                +"}\n";
    }
}

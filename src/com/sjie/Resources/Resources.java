package com.sjie.Resources;

import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.SelectionModel;
import com.intellij.openapi.project.Project;
import com.sjie.BaseBuilder;

public class Resources extends BaseBuilder {
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
                        builder=color();
                        break;
                    case 1:
                        builder=Line();
                        break;
                    case 2:
                        builder=rect();
                        break;
                    case 3:
                        builder=colorrect();
                        break;
                    case 4:
                        builder=circle();
                        break;
                    case 5:
                        builder=dcircle();
                        break;
                    case 6:
                        builder=bkselect();
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
    private String color(){
        return "<color name=\"transparent\">#00000000</color><!--透明色 -->\n"
               +"<color name=\"white\">#FFFFFF</color><!--白色 -->\n"
               +"<color name=\"ivory\">#FFFFF0</color><!--象牙色 -->\n"
               +"<color name=\"lightyellow\">#FFFFE0</color><!--亮黄色 -->\n"
               +"<color name=\"yellow\">#FFFF00</color><!--黄色 -->\n"
               +"<color name=\"snow\">#FFFAFA</color><!--雪白色 -->\n"
               +"<color name=\"floralwhite\">#FFFAF0</color><!--花白色 -->\n"
               +"<color name=\"lemonchiffon\">#FFFACD</color><!--柠檬绸色 -->\n"
               +"<color name=\"cornsilk\">#FFF8DC</color><!--米绸色 -->\n"
               +"<color name=\"seashell\">#FFF5EE</color><!--海贝色 -->\n"
               +"<color name=\"lavenderblush\">#FFF0F5</color><!--淡紫红 -->\n"
               +"<color name=\"papayawhip\">#FFEFD5</color><!--番木色 -->\n"
               +"<color name=\"blanchedalmond\">#FFEBCD</color><!--白杏色 -->\n\n"
               +"<color name=\"mistyrose\">#FFE4E1</color><!--浅玫瑰色 -->\n"
               +"<color name=\"bisque\">#FFE4C4</color><!--桔黄色 -->\n"
               +"<color name=\"moccasin\">#FFE4B5</color><!--鹿皮色 -->\n"
               +"<color name=\"navajowhite\">#FFDEAD</color><!--纳瓦白 -->\n"
               +"<color name=\"peachpuff\">#FFDAB9</color><!--桃色 -->\n"
               +"<color name=\"gold\">#FFD700</color><!--金色 -->\n"
               +"<color name=\"pink\">#FFC0CB</color><!--粉红色 -->\n"
               +"<color name=\"lightpink\">#FFB6C1</color><!--亮粉红色 -->\n"
               +"<color name=\"orange\">#FFA500</color><!--橙色 -->\n"
               +"<color name=\"lightsalmon\">#FFA07A</color><!--亮肉色 -->\n"
               +"<color name=\"darkorange\">#FF8C00</color><!--暗桔黄色 -->\n"
               +"<color name=\"coral\">#FF7F50</color><!--珊瑚色 -->\n"
               +"<color name=\"hotpink\">#FF69B4</color><!--热粉红色 -->\n"
               +"<color name=\"tomato\">#FF6347</color><!--西红柿色 -->\n"
               +"<color name=\"orangered\">#FF4500</color><!--红橙色 -->\n"
               +"<color name=\"deeppink\">#FF1493</color><!--深粉红色 -->\n"
               +"<color name=\"fuchsia\">#FF00FF</color><!--紫红色 -->\n"
               +"<color name=\"red\">#FF0000</color><!--红色 -->\n"
               +"<color name=\"oldlace\">#FDF5E6</color><!--老花色 -->\n"
               +"<color name=\"lightgoldenrodyellow\">#FAFAD2</color><!--亮金黄色 -->\n"
               +"<color name=\"linen\">#FAF0E6</color><!--亚麻色 -->\n"
               +"<color name=\"antiquewhite\">#FAEBD7</color><!--古董白 -->\n"
               +"<color name=\"salmon\">#FA8072</color><!--鲜肉色 -->\n"
               +"<color name=\"ghostwhite\">#F8F8FF</color><!--幽灵白 -->\n"
               +"<color name=\"mintcream\">#F5FFFA</color><!--薄荷色 -->\n"
               +"<color name=\"whitesmoke\">#F5F5F5</color><!--烟白色 -->\n"
               +"<color name=\"beige\">#F5F5DC</color><!--米色 -->\n"
               +"<color name=\"wheat\">#F5DEB3</color><!--浅黄色 -->\n"
               +"<color name=\"sandybrown\">#F4A460</color><!--沙褐色 -->\n"
               +"<color name=\"azure\">#F0FFFF</color><!--天蓝色 -->\n"
               +"<color name=\"honeydew\">#F0FFF0</color><!--蜜色 -->\n"
               +"<color name=\"aliceblue\">#F0F8FF</color><!--艾利斯兰 -->\n"
               +"<color name=\"khaki\">#F0E68C</color><!--黄褐色 -->\n"
               +"<color name=\"lightcoral\">#F08080</color><!--亮珊瑚色 -->\n"
               +"<color name=\"palegoldenrod\">#EEE8AA</color><!--苍麒麟色 -->\n\n"
               +"<color name=\"violet\">#EE82EE</color><!--紫罗兰色 -->\n"
               +"<color name=\"darksalmon\">#E9967A</color><!--暗肉色 -->\n"
               +"<color name=\"lavender\">#E6E6FA</color><!--淡紫色 -->\n"
               +"<color name=\"lightcyan\">#E0FFFF</color><!--亮青色 -->\n"
               +"<color name=\"burlywood\">#DEB887</color><!--实木色 -->\n"
               +"<color name=\"plum\">#DDA0DD</color><!--洋李色 -->\n"
               +"<color name=\"gainsboro\">#DCDCDC</color><!--淡灰色 -->\n"
               +"<color name=\"crimson\">#DC143C</color><!--暗深红色 -->\n"
               +"<color name=\"palevioletred\">#DB7093</color><!--苍紫罗兰色 -->\n"
               +"<color name=\"goldenrod\">#DAA520</color><!--金麒麟色 -->\n"
               +"<color name=\"orchid\">#DA70D6</color><!--淡紫色 -->\n"
               +"<color name=\"thistle\">#D8BFD8</color><!--蓟色 -->\n"
               +"<color name=\"lightgray\">#D3D3D3</color><!--亮灰色 -->\n"
               +"<color name=\"tan\">#D2B48C</color><!--茶色 -->\n"
               +"<color name=\"chocolate\">#D2691E</color><!--巧可力色 -->\n"
               +"<color name=\"peru\">#CD853F</color><!--秘鲁色 -->\n"
               +"<color name=\"indianred\">#CD5C5C</color><!--印第安红 -->\n"
               +"<color name=\"mediumvioletred\">#C71585</color><!--中紫罗兰色 -->\n"
               +"<color name=\"silver\">#C0C0C0</color><!--银色 -->\n"
               +"<color name=\"darkkhaki\">#BDB76B</color><!--暗黄褐色 -->\n"
               +"<color name=\"rosybrown\">#BC8F8F</color><!--褐玫瑰红 -->\n"
               +"<color name=\"mediumorchid\">#BA55D3</color><!--中粉紫色 -->\n"
               +"<color name=\"darkgoldenrod\">#B8860B</color><!--暗金黄色 -->\n\n"
               +"<color name=\"firebrick\">#B22222</color><!--火砖色 -->\n"
               +"<color name=\"powderblue\">#B0E0E6</color><!--粉蓝色 -->\n"
               +"<color name=\"lightsteelblue\">#B0C4DE</color><!--亮钢兰色 -->\n"
               +"<color name=\"paleturquoise\">#AFEEEE</color><!--苍宝石绿 -->\n\n"
               +"<color name=\"greenyellow\">#ADFF2F</color><!--黄绿色 -->\n"
               +"<color name=\"lightblue\">#ADD8E6</color><!--亮蓝色 -->\n"
               +"<color name=\"darkgray\">#A9A9A9</color><!--暗灰色 -->\n"
               +"<color name=\"brown\">#A52A2A</color><!--褐色 -->\n"
               +"<color name=\"sienna\">#A0522D</color><!--赭色 -->\n"
               +"<color name=\"darkorchid\">#9932CC</color><!--暗紫色 -->\n"
               +"<color name=\"palegreen\">#98FB98</color><!--苍绿色 -->\n"
               +"<color name=\"darkviolet\">#9400D3</color><!--暗紫罗兰色 -->\n"
               +"<color name=\"mediumpurple\">#9370DB</color><!--中紫色 -->\n"
               +"<color name=\"lightgreen\">#90EE90</color><!--亮绿色 -->\n"
               +"<color name=\"darkseagreen\">#8FBC8F</color><!--暗海兰色 -->\n"
               +"<color name=\"saddlebrown\">#8B4513</color><!--重褐色 -->\n"
               +"<color name=\"darkmagenta\">#8B008B</color><!--暗洋红 -->\n"
               +"<color name=\"darkred\">#8B0000</color><!--暗红色 -->\n"
               +"<color name=\"blueviolet\">#8A2BE2</color><!--紫罗兰蓝色 -->\n"
               +"<color name=\"lightskyblue\">#87CEFA</color><!--亮天蓝色 -->\n"
               +"<color name=\"skyblue\">#87CEEB</color><!--天蓝色 -->\n"
               +"<color name=\"gray\">#808080</color><!--灰色 -->\n"
               +"<color name=\"olive\">#808000</color><!--橄榄色 -->\n"
               +"<color name=\"purple\">#800080</color><!--紫色 -->\n"
               +"<color name=\"maroon\">#800000</color><!--粟色 -->\n"
               +"<color name=\"aquamarine\">#7FFFD4</color><!--碧绿色 -->\n"
               +"<color name=\"chartreuse\">#7FFF00</color><!--黄绿色 -->\n"
               +"<color name=\"lawngreen\">#7CFC00</color><!--草绿色 -->\n"
               +"<color name=\"mediumslateblue\">#7B68EE</color><!--中暗蓝色 -->\n"
               +"<color name=\"lightslategray\">#778899</color><!--亮蓝灰 -->\n"
               +"<color name=\"slategray\">#708090</color><!--灰石色 -->\n"
               +"<color name=\"olivedrab\">#6B8E23</color><!--深绿褐色 -->\n"
               +"<color name=\"slateblue\">#6A5ACD</color><!--石蓝色 -->\n"
               +"<color name=\"dimgray\">#696969</color><!--暗灰色 -->\n"
               +"<color name=\"mediumaquamarine\">#66CDAA</color><!--中绿色 -->\n"
               +"<color name=\"cornflowerblue\">#6495ED</color><!--菊兰色 -->\n"
               +"<color name=\"cadetblue\">#5F9EA0</color><!--军兰色 -->\n"
               +"<color name=\"darkolivegreen\">#556B2F</color><!--暗橄榄绿 -->\n"
               +"<color name=\"indigo\">#4B0082</color><!--靛青色 -->\n"
               +"<color name=\"mediumturquoise\">#48D1CC</color><!--中绿宝石 -->\n"
               +"<color name=\"darkslateblue\">#483D8B</color><!--暗灰蓝色 -->\n"
               +"<color name=\"steelblue\">#4682B4</color><!--钢兰色 -->\n"
               +"<color name=\"royalblue\">#4169E1</color><!--皇家蓝 -->\n"
               +"<color name=\"turquoise\">#40E0D0</color><!--青绿色 -->\n"
               +"<color name=\"mediumseagreen\">#3CB371</color><!--中海蓝 -->\n"
               +"<color name=\"limegreen\">#32CD32</color><!--橙绿色 -->\n"
               +"<color name=\"darkslategray\">#2F4F4F</color><!--暗瓦灰色 -->\n"
               +"<color name=\"seagreen\">#2E8B57</color><!--海绿色 -->\n"
               +"<color name=\"forestgreen\">#228B22</color><!--森林绿 -->\n"
               +"<color name=\"lightseagreen\">#20B2AA</color><!--亮海蓝色 -->\n"
               +"<color name=\"dodgerblue\">#1E90FF</color><!--闪兰色 -->\n"
               +"<color name=\"midnightblue\">#191970</color><!--中灰兰色 -->\n"
               +"<color name=\"aqua\">#00FFFF</color><!--浅绿色 -->\n"
               +"<color name=\"cyan\">#00FFFF</color><!--青色 -->\n"
               +"<color name=\"springgreen\">#00FF7F</color><!--春绿色 -->\n"
               +"<color name=\"lime\">#00FF00</color><!--酸橙色 -->\n"
               +"<color name=\"mediumspringgreen\">#00FA9A</color><!--中春绿色 -->\n"
               +"<color name=\"darkturquoise\">#00CED1</color><!--暗宝石绿 -->\n"
               +"<color name=\"deepskyblue\">#00BFFF</color><!--深天蓝色 -->\n"
               +"<color name=\"darkcyan\">#008B8B</color><!--暗青色 -->\n"
               +"<color name=\"teal\">#008080</color><!--水鸭色 -->\n"
               +"<color name=\"green\">#008000</color><!--绿色 -->\n"
               +"<color name=\"darkgreen\">#006400</color><!--暗绿色 -->\n"
               +"<color name=\"blue\">#0000FF</color><!--蓝色 -->\n"
               +"<color name=\"mediumblue\">#0000CD</color><!--中兰色 -->\n"
               +"<color name=\"darkblue\">#00008B</color><!--暗蓝色 -->\n"
               +"<color name=\"navy\">#000080</color><!--海军色 -->\n"
               +"<color name=\"black\">#000000</color><!--黑色 -->\n"
               +"<color name=\"grassgreen\">#99cc33</color><!--草绿色 -->\n"
               +"<color name=\"gray_cc\">#cccccc</color><!--灰色cc -->\n"
                +"<color name=\"gray_8f\">#8f8f8f</color><!--灰色8f -->\n";
    }
    private String Line(){
        return "<shape xmlns:android=\"http://schemas.android.com/apk/res/android\"\n"
                +"    android:shape=\"line\" >\n"
                +"<stroke\n"
                +"    android:dashGap=\"3dp\"\n"
                +"    android:dashWidth=\"6dp\"\n"
                +"    android:width=\"1dp\"\n"
                +"    android:color=\"#bfbfbf\" />\n"
                +"<!-- 虚线的高度 -->\n"
                +"<size android:height=\"1dp\" />\n"
                +"</shape>\n";
    }
    private String rect(){
        return "<shape xmlns:android=\"http://schemas.android.com/apk/res/android\"\n"
                +"    android:shape=\"rectangle\">\n"
                +"<!-- 填充颜色 -->\n"
                +"<solid android:color=\"#fff121\"></solid>\n"
                +"<!-- 线的宽度，颜色灰色 -->\n"
                +"<stroke android:width=\"1dp\" android:color=\"#000000\"></stroke>\n"
                +"<!-- 矩形的圆角半径 -->\n"
                +"<corners android:radius=\"10dp\" />\n"
                +"</shape>\n";
    }
    private String colorrect(){
        return "<shape xmlns:android=\"http://schemas.android.com/apk/res/android\"\n"
                +"    android:shape=\"rectangle\">\n"
                +"<!--分別對應上面左圆角的半径，上面右圆角的半径，下面左圆角的半径，下面右圆角的半径-->\n"
                +"<corners\n"
                +"    android:topLeftRadius=\"0dp\"\n"
                +"    android:topRightRadius=\"7dp\"\n"
                +"    android:bottomLeftRadius=\"0dp\"\n"
                +"    android:bottomRightRadius=\"7dp\"/>\n"
                +"<!--設置渐变-->\n"
                +"<gradient android:startColor=\"#9cff00\"\n"
                +"    android:endColor=\"#197600\"\n"
                +"    android:angle=\"270\"/>\n"
                +"<stroke\n"
                +"    android:width=\"1dp\"\n"
                +"    android:color=\"#63a219\" />\n"
                +"</shape>\n";
    }
    private String circle(){
        return "<shape xmlns:android=\"http://schemas.android.com/apk/res/android\"\n"
               +"    android:shape=\"oval\">\n"
               +"    <solid android:color=\"#00ff00\"/>\n"
               +"    <stroke android:width=\"0.5dp\" android:color=\"@color/main_yellow_button\"/>\n"
               +"    <!--warp-parent下使用--!>\n"
               +"    <size android:width=\"50dp\"\n"
               +"    android:height=\"50dp\"/>\n"
               +"</shape>\n";
    }
    private String dcircle(){
        return "<layer-list xmlns:android=\"http://schemas.android.com/apk/res/android\" >\n"
                +"<!-- outer circle -->\n"
                +"<item\n"
                +"    android:width=\"40dp\"\n"
                +"    android:height=\"40dp\">\n"
                +"<shape android:shape=\"oval\">\n"
                +"<stroke android:width=\"1dp\" android:color=\"#000000\"></stroke>\n"
                +"</shape>\n"
                +"</item>\n"
                +"<item\n"
                +"    android:bottom=\"2dp\"\n"
                +"    android:left=\"2dp\"\n"
                +"    android:top=\"2dp\"\n"
                +"    android:right=\"2dp\">\n"
                +"<shape android:shape=\"oval\">\n"
                +"<stroke android:width=\"1dp\" android:color=\"#00f00f\"></stroke>\n"
                +"</shape>\n"
                +"</item>\n"
                +"</layer-list>\n";
    }
    private String bkselect(){
        return "<selector xmlns:android=\"http://schemas.android.com/apk/res/android\"\n"
                +"    android:enterFadeDuration=\"1000\"\n"
                +"    android:exitFadeDuration=\"1500\">\n"
                +"    <item\n"
                +"    android:state_pressed=\"true\"\n"
                +"    android:drawable=\"@color/colorAccent\"/>\n"
                +"    <item\n"
                +"    android:drawable=\"@color/colorPrimary\"/>\n"
                +"</selector>\n";
    }
}

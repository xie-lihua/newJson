import com.google.gson.internal.bind.util.ISO8601Utils;
import org.json.JSONObject;
import org.yaml.snakeyaml.Yaml;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author xie-lihang
 * @time 2023-5-22
 */
public class JsontoYamlConverter {

    public static void main(String[] args) {
        System.out.println("这是Json To Yaml 文件的转换！");
        Scanner scanner = new Scanner(System.in);

        // 输入Json文件路径
        String jsonFilePath = "C:\\Users\\xie74\\Desktop\\output29.json";
        //下面这两行可以注释掉（如果在上面已经写好了路径）
        System.out.print("请输入json文件路径：");
        jsonFilePath = scanner.nextLine();

        // 输出Yaml文件路径
        String yamlFilePath = "C:\\Users\\xie74\\Desktop\\output14.yaml";
        //下面这两行可以注释掉（如果在上面已经写好了路径）
        System.out.print("请输出YAML文件路径：");
        yamlFilePath = scanner.nextLine();


        try {
            // 读取JSON文件内容
            FileReader jsonFileReader = new FileReader(jsonFilePath);
            StringBuilder jsonContent = new StringBuilder();
            int character;
            while ((character = jsonFileReader.read()) != -1) {
                jsonContent.append((char) character);
            }
            jsonFileReader.close();

            // 创建JSON对象
            JSONObject jsonObject = new JSONObject(jsonContent.toString());

            // 转换为YAML格式
            Yaml yaml = new Yaml();
            String yamlContent = yaml.dump(jsonObject.toMap());

            // 将YAML内容写入文件
            FileWriter yamlFileWriter = new FileWriter(yamlFilePath);
            yamlFileWriter.write(yamlContent);
            yamlFileWriter.close();

            System.out.println("转换成功，请到指定路径查看");
        } catch (IOException e) {
            System.out.println("转换失败，输入或输出文件有误");
        }
    }
}

import org.json.JSONObject;
import org.yaml.snakeyaml.Yaml;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Map;
import java.util.Scanner;

/**
 * @author xie-lihang
 * @time 2023-5-22
 */

public class YamltoJsonConverter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 输入YAML文件路径
        String yamlFilePath = "C:\\Users\\xie74\\Desktop\\input.yaml";
        //下面这两行可以注释掉（如果在上面已经写好了路径）
        System.out.print("请输入YAML文件路径：");
        yamlFilePath = scanner.nextLine();

        // 输出JSON文件路径
        String jsonFilePath = "C:\\Users\\xie74\\Desktop\\output29.json";
        //下面这两行可以注释掉（如果在上面已经写好了路径）
        System.out.print("请输出json文件路径：");
        jsonFilePath = scanner.nextLine();

        try {
            // 读取YAML文件内容
            FileReader yamlFileReader = new FileReader(yamlFilePath);
            Yaml yaml = new Yaml();
            Map<String, Object> yamlData = yaml.load(yamlFileReader);

            // 转换为JSON格式
            JSONObject jsonObject = new JSONObject(yamlData);

            // 将JSON内容写入文件
            FileWriter jsonFileWriter = new FileWriter(jsonFilePath);
            jsonFileWriter.write(jsonObject.toString());
            jsonFileWriter.close();

            System.out.println("转换成功，请到指定路径查看");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

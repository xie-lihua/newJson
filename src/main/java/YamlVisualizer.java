/*import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Scanner;

public class YamlVisualizer {
    public static void visualize(String filename) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(filename));
        String yamlString = new String(encoded, StandardCharsets.UTF_8);

        Yaml yaml = new Yaml();
        Map<String, Object> map = yaml.load(yamlString);
        String prettyYaml = yaml.dump(map);

        System.out.println(prettyYaml);
    }

    public static String read(String filename) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(filename));
        String yamlString = new String(encoded, StandardCharsets.UTF_8);

        Yaml yaml = new Yaml();
        Map<String, Object> map = yaml.load(yamlString);
        return yaml.dump(map);
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入文件路径：");
        String filePath = scanner.nextLine();

        String yamlString = read(filePath);
        System.out.println(yamlString);

        visualize(yamlString);
    }
}*/
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Scanner;
import org.yaml.snakeyaml.Yaml;
/**
 * @author xie-lihang
 * @time 2023-5-22
 */

public class YamlVisualizer {

    //读取yaml文件
    public static void visualize(String filePath) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(filePath));
        String yamlString = new String(encoded, StandardCharsets.UTF_8);

        Yaml yaml = new Yaml();
        Map<String, Object> map = yaml.load(yamlString);
        String prettyYaml = yaml.dump(map);
    //打印结果
        System.out.println(prettyYaml);
    }

    public static void main(String[] args) throws IOException {
        // 获取用户输入的文件路径
        Scanner scanner = new Scanner(System.in);
        System.out.println("这是yaml文件的可视化！");
        try{
        System.out.print("请输入 YAML 文件路径：");
        String filePath = scanner.nextLine();

        // 执行可视化操作
        visualize(filePath);
    }
        catch (IOException e) {
            System.out.println("未找到文件！");
        }
}}
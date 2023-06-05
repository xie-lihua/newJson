import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * @author xie-lihua
 * @time 2023/5/23
 */
public class JsonVisualizer {

    public static String read(String filename) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(filename));
        return new String(encoded, StandardCharsets.UTF_8);
    }
    private static final ObjectMapper mapper = new ObjectMapper()
            .enable(SerializationFeature.INDENT_OUTPUT);

    public static void visualize(String json) throws Exception {
        ObjectNode obj = mapper.readValue(json, ObjectNode.class);
        String prettyJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
        System.out.println(prettyJson);
    }
    public static void main(String[] args) throws Exception {
        System.out.println("这是json文件的可视化！");
        String jsontxt = read("C:\\Users\\xie74\\Desktop\\input.json");
        //两种方式写路径
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入JSON 文件路径：");
        try{
        String filePath = scanner.nextLine();
        jsontxt=read(filePath);
        JsonVisualizer.visualize(jsontxt);
}catch (Exception e) {
            System.out.println("未找到文件！");
}

    }}
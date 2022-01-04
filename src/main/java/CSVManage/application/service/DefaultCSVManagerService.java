package CSVManage.application.service;

import CSVManage.application.port.in.CSVManageService;
import CSVManage.domain.model.CSVModel;


import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DefaultCSVManagerService implements CSVManageService {
    public static final Pattern CSVPattern = Pattern.compile("\"()()(([\\d]+?)-([\\d]+?)-([\\d]+?))\",\"([\\s\\S]*?)\",\"([\\s\\S]*?)\"(\\r\\n|\\r|\\n)", Pattern.MULTILINE);
    public static final Charset UTF8 = StandardCharsets.UTF_8;

    public String KRToCN(String string) {
        char[] c = string.toCharArray();
        for(int i=0; i < c.length; i++) if (c[i] >= 0xAC00 && c[i] <= 0xEA00) c[i] -= 0x3E00;
        return new String(c);
    }

    public String CNtoKR(String string) {
        char[] c = string.toCharArray();
        for(int i=0; i < c.length; i++) if (c[i] >= 0x6E00 && c[i] <= 0xAC00) c[i] += 0x3E00;
        return new String(c);
    }


    @Override
    public boolean makeCSVoutput(List<CSVModel> target) {
        return false;
    }

    @Override
    public List<CSVModel> parseCSVFile(String filename) throws Exception{
        List<CSVModel> result = new ArrayList<>();
        List<String> lines = Files.readAllLines(Paths.get(filename));
        for(String oneLine : lines){
            Matcher m = CSVPattern.matcher(oneLine);
            if(m.find()){
                CSVModel oneCsv = new CSVModel(m.group(3), m.group(7), m.group(8));
                result.add(oneCsv);
            }else {
                System.out.println("no csv pattern found ["+oneLine+"]");
            }
        }
        return result;
    }

    @Override
    public List<CSVModel> mergeCSV(CSVModel base, CSVModel target) {
        return null;
    }

    @Override
    public List<CSVModel> transKRtoCN(List<CSVModel> originKR) {
        List<CSVModel> result = new ArrayList<>();
        for(CSVModel oneModel : originKR){
            CSVModel convertedModel = new CSVModel(oneModel);
            String CNconverted = this.KRToCN(oneModel.getTarget());
            convertedModel.setTarget(CNconverted);
            result.add(convertedModel);
        }
        return result;
    }

    @Override
    public List<CSVModel> transCNtoKR(List<CSVModel> originCN) {
        List<CSVModel> result = new ArrayList<>();
        for(CSVModel oneModel : originCN){
            CSVModel convertedModel = new CSVModel(oneModel);
            String CNconverted = this.CNtoKR(oneModel.getTarget());
            convertedModel.setTarget(CNconverted);
            result.add(convertedModel);
        }
        return result;
    }

    @Override
    public boolean pullCSVFromGithub(String localPath) {
        return false;
    }

    @Override
    public boolean pushCSVtoGithub(String localPath) {
        return false;
    }
}

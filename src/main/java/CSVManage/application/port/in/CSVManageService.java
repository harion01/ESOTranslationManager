package CSVManage.application.port.in;

import CSVManage.domain.model.CSVModel;

import java.util.List;

public interface CSVManageService {
    boolean makeCSVoutput(List<CSVModel> target);
    List<CSVModel> parseCSVFile(String filename) throws Exception;
    List<CSVModel> mergeCSV(CSVModel base, CSVModel target);
    List<CSVModel> transKRtoCN(List<CSVModel> originKR);
    List<CSVModel> transCNtoKR(List<CSVModel> originCN);

    boolean pullCSVFromGithub(String localPath);
    boolean pushCSVtoGithub(String localPath);
}

package CSVManage.application.service;

import CSVManage.domain.model.CSVModel;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DefaultCSVManagerServiceTest {
    public static DefaultCSVManagerService service;

    @BeforeAll
    static void init(){
        service = new DefaultCSVManagerService();
    }

    @Test
    void makeCSVoutput() {
        //service.makeCSVoutput();
    }

    @Test
    void parseCSVFile() throws Exception {
        String filename = "src/test/resources/en_small.lang.csv";
        List<CSVModel> parsedList = service.parseCSVFile(filename);
        List<String> lines = Files.readAllLines(Paths.get(filename));
        assertEquals( lines.size()-1, parsedList.size());
    }

    @Test
    void mergeCSV() {
    }

}
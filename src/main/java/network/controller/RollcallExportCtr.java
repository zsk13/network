package network.controller;

import network.common.ViewExcel;
import network.service.RollcallExportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "export")
public class RollcallExportCtr {
    @Autowired
    private RollcallExportService rollcallExportService;

    @RequestMapping("/rollcallExport.do")
    public ModelAndView export(Long rId, ModelMap map) throws Exception {
        List<Map<String, String>> list = rollcallExportService.selectAllRollCall(rId);
        String[] titles = {"学号", "姓名", "是否签到"};
        ViewExcel excel = new ViewExcel(titles);
        map.put("excelList", list);
        return new ModelAndView(excel, map);
    }
}

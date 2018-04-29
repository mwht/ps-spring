package pl.madejspace.postudencku.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class StaticAssetController {

    @RequestMapping(value = "/staticAsset/{assetName}", method = GET)
    @ResponseBody
    public String getAsset(@PathVariable String assetName, Model model) {
        return assetName;
    }
}

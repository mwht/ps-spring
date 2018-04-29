package pl.madejspace.postudencku.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class StaticAssetController {

    @RequestMapping(value = "/staticAsset/{assetName}", method = GET)
    @ResponseBody
    public byte[] getAsset(@PathVariable String assetName, Model model) {
        ClassLoader classLoader = getClass().getClassLoader();
        try {
            String assetString = new String(Base64.getDecoder().decode(assetName), StandardCharsets.UTF_8);
            File asset = new File(classLoader.getResource("assets/"+assetString).getFile());
            byte[] data = new byte[(int)asset.length()];
            DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream(classLoader.getResource("assets/"+assetString).getFile())));
            dis.readFully(data);
            dis.close();
            return data;
        } catch(Exception e) {
            return ("Could not serve asset - " + e.getClass().getName() + ": " + e.getMessage()).getBytes();
        }
    }
}

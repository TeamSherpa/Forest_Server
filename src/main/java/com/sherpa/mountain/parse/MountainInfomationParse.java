package com.sherpa.mountain.parse;

import com.google.gson.*;
import com.sherpa.network.APIConfiguration;
import com.sherpa.network.NetworkRequestor;

import java.util.ArrayList;
import java.util.List;

public class MountainInfomationParse {

    public static MountainInfomationParse shared = new MountainInfomationParse();

    private MountainInfomationParse() {

    }

    public List<Mountain> parse() {
        String url = "http://apis.data.go.kr/1400000/service/cultureInfoService/mntInfoOpenAPI?" +
                     "ServiceKey=" + APIConfiguration.serviceKey +
                     "&_type=json&numOfRows=3368";

        String method = "GET";

        NetworkRequestor requestor = new NetworkRequestor(url, method);
        List<Mountain> mountains = new ArrayList<Mountain>();
        try {
            requestor.connect();
            String jsonData = requestor.getOutputStream();
            JsonObject jsonObject = new JsonParser().parse(jsonData).getAsJsonObject();
            JsonArray jsonElements = jsonObject.get("response").getAsJsonObject()
                                               .get("body").getAsJsonObject()
                                               .get("items").getAsJsonObject()
                                               .get("item").getAsJsonArray();
            Gson gson = new Gson();
            for (JsonElement element: jsonElements) {
                Mountain mountain = gson.fromJson(element, Mountain.class);
                mountains.add(mountain);
            };
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mountains;
    }

    public MountainImage parse(String code) {
        String url = "http://apis.data.go.kr/1400000/service/cultureInfoService/mntInfoImgOpenAPI?" +
                "ServiceKey=" + APIConfiguration.serviceKey +
                "&_type=json&mntiListNo=" + code
                +"&numOfRows=1";

        String method = "GET";

        NetworkRequestor requestor = new NetworkRequestor(url, method);
        try {
            requestor.connect();
            String jsonData = requestor.getOutputStream();
            System.out.print(jsonData);
            JsonObject jsonObject = new JsonParser().parse(jsonData).getAsJsonObject();
            JsonElement items = jsonObject.get("response").getAsJsonObject()
                    .get("body").getAsJsonObject()
                    .get("items");

            if (items.isJsonObject()) {
                items = items.getAsJsonObject()
                             .get("item");
                Gson gson = new Gson();
                MountainImage image = gson.fromJson(items, MountainImage.class);
                image.setImgfilename("www.forest.go.kr/images/data/down/mountain/" + image.getImgfilename());
                image.setCode(code);
                return image;
            }

            return new MountainImage();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new MountainImage();
    }
}

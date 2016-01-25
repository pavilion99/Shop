package tech.spencercolton.shop.Util;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import tech.spencercolton.shop.Exceptions.InventoryParseException;
import tech.spencercolton.shop.Shop;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Spencer Colton
 */
public class JSONLoader {

    public static Map<String, JSONObject> objs = new HashMap<>();

    @SuppressWarnings("unchecked")
    public static JSONObject get(String s) throws InventoryParseException, IOException, ParseException {
        if(objs.containsKey(s))
            return objs.get(s);

        if(!(s.endsWith(".json")))
            s += ".json";

        File f = new File(Shop.getDf(), s);

        if(!f.exists())
            throw new InventoryParseException("File \"" + f.toString() + "\" does not seem to exist.");

        JSONParser p = new JSONParser();
        JSONObject j = (JSONObject)p.parse(new InputStreamReader(new FileInputStream(f)));

        objs.put(s, j);
        return j;
    }

    @SuppressWarnings("unchecked")
    public static void genMissing() {
        try {
            File f = new File(Shop.getDf(), "main.json");
            if (!f.exists()) {
                JSONObject j = new JSONObject();
                j.put("name", null);
                j.put("items", new HashMap<Integer, Map<String, Object>>());
                j.put("actions", new HashMap<Integer, String>());
                FileWriter g = new FileWriter(f);
                g.write(j.toString());
                g.close();
            }
        } catch (IOException e) {

        }
    }

    public static void saveNew(String s) {
        if(Shop.newInventory.get(s) == null)
            return;


    }

}

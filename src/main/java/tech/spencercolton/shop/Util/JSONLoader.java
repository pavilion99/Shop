package tech.spencercolton.shop.Util;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import tech.spencercolton.shop.Exceptions.InventoryParseException;
import tech.spencercolton.shop.Shop;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Spencer Colton
 */
public class JSONLoader {

    public static JSONObject get(String s) throws InventoryParseException, IOException, ParseException {
        if(!(s.endsWith(".json")))
            s += ".json";

        File f = new File(Shop.getDf(), s);

        if(!f.exists())
            throw new InventoryParseException("File \"" + f.toString() + "\" does not seem to exist.");

        JSONParser p = new JSONParser();
        p.parse(new InputStreamReader(new FileInputStream(f)));


    }

}

// given a json structure:
// {
//     f1:v1,
//     f2:{
//         f21:v21,
//         f4: {
//             f41:v41,
//             }
//         },
//     f3:[
//         {
//             f31:v31,
//         },
//         {
//             f31:v32,
//             ..
//         }
//     ]
// }

// parse above json to generate following map :
// map : {
// root : [f1,f2,f3]
// f2: [f21,f4,..]
// f2.f4: [f41,..]
// f3: [f31,..]
// }
import java.security.Key;
import java.util.*;

public class JLLTest2 {

    public static void main(String[] args) {
        JsonObject json = new JsonObject("");
        Map<String, List<String>> map = new HashMap<>();
        processJson(json, map, "");
    }

    void processJson(Json json, Map<String, List<String>> map, String keyTillNow) {
        List<String> keys = json.getKeys();
        for (String key : keys) {
            String keyValue = json.get(key);
            if (keyValue == null) {
                continue;
            }
            if (keyValue instanceof jsonArray && keyValue.getSize() > 0) {
                processJson(keyValue.get(0), map, keyTillNow.isEmpty() ? key : keyTillNow + "." + key);
            } else if (keyValue instanceof JsonObject) {
                processJson(keyValue, map, keyTillNow.isEmpty() ? key : keyTillNow + "." + key);
            }
        }
        map.put(keyTillNow, keys);
    }

}
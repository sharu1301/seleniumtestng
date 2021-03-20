package Variables;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Map;

import org.yaml.snakeyaml.Yaml;

public class objectProperties {

	static Map<?,?> property;
	static String objectfilepath = "ObjectRepository/Objects.yml";
	
	public static void initializeObjectProperties()
	{
		try {
			Reader rd = new FileReader(objectfilepath);
			Yaml yml = new Yaml();
			property = (Map<?,?>) yml.load(rd);
			rd.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static String getElementProperty(String objectstring)
	{
		Map<?,?> map = (Map<?,?>) property.get(objectstring.split("\\.")[0]);
		return map.get(objectstring.split("\\.")[1]).toString();
	}
}





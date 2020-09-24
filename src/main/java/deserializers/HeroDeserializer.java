package deserializers;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import pojos.Hero;

public class HeroDeserializer extends JsonDeserializer<Hero>{

	@Override
	public Hero deserialize(JsonParser parser, DeserializationContext context) throws IOException, JsonProcessingException {
//		context.getParser().getC
		return null;
	}
	
}

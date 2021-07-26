package mapper.datamapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * CONVERT ENTITY OBJECT AND DTO OBJECT
 * 
 * @author Witor S. Olievira
 *
 */
@Configuration
public class Mapper implements DataMapper {

	/**
	 * DEFINE MODEL MAPPER TO CONFIG GLOBAL TO SPRING
	 * 
	 * @return
	 */
	@Bean
	public ModelMapper model() {
		return new ModelMapper();
	}

	/**
	 * RETURN ONE MAP OBJECT
	 */
	public <D> D map(Object source, Class<D> destinationType) {
		return this.model().map(source, destinationType);
	}

	/**
	 * RETURN LIST TO MULTIPLES MAPS OBJECTS
	 */
	public <S, T> List<T> map(List<S> source, Class<T> targetClass) {
		return source.stream().map(element -> this.model().map(element, targetClass)).collect(Collectors.toList());
	}

}

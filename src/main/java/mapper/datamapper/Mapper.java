package mapper.datamapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Mapper implements ModelMapperCustom {

	/**
	 * DEFINE O MODEL MAPPER COMO UMA CONFIGURAÇÃO GLOBAL E PADRÃO NO SISTEMA
	 * UTILIZADO PARA CONVERTER ENTITY EM DTO
	 * 
	 * @return
	 */
	@Bean
	public ModelMapper model() {
		return new ModelMapper();
	}

	/**
	 * RETORNA UM OBJETO DTO DE UM OBJETO ENTITY
	 */
	public <D> D map(Object source, Class<D> destinationType) {
		return this.model().map(source, destinationType);
	}

	/**
	 * RETORNA UMA LISTA COM MAP DTO DE UMA LISTA DE ENTITY
	 */
	public <S, T> List<T> mapList(List<S> source, Class<T> targetClass) {
		return source.stream().map(element -> this.model().map(element, targetClass)).collect(Collectors.toList());
	}

}

package mapper.datamapper;

import java.util.List;

import org.mapstruct.Mapper;

@Mapper
public interface ModelMapperCustom {

	public <S, T> List<T> mapList(List<S> source, Class<T> targetClass);

	public <D> D map(Object source, Class<D> destinationType);

}

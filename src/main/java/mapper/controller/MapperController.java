package mapper.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import mapper.datamapper.Mapper;
import mapper.dto.MapperDto;
import mapper.entity.MapperEntity;

@Controller
public class MapperController {

	@Autowired
	private Mapper mapper;

	public void example() {
		var entity = new MapperEntity();
		entity.setName("Mapper");

		MapperDto mapObject = this.mapper.map(entity, MapperDto.class);
		System.out.println(mapObject);

		List<MapperEntity> entityList = new ArrayList<>();
		entityList.add(entity);

		List<MapperDto> mapListObject = this.mapper.map(entityList, MapperDto.class);
		System.out.println(mapListObject);
	}

}

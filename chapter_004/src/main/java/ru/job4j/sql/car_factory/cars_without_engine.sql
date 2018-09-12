select car.name, engine.name from car 
right outer join engine on car.engine_id=engine.id where car is null;

select car.name, car_body.name from car 
right outer join car_body on car.car_body_id=car_body.id where car is null;

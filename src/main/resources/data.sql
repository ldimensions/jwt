INSERT INTO `jwt`.`agency` (`id`, `address1`, `address2`, `agency_name`, `city`, `status`) 
	VALUES 
		('1', 'add 1', 'add 2', 'Vettom', 'Ktym', '1'),
		('2', 'add 1', 'add 2', 'Kanachikuzi', 'Tvm', '1');

SET FOREIGN_KEY_CHECKS=0;
INSERT INTO `jwt`.`user` (`id`, `user_name`, `password`, `first_name`, `middle_name`, `last_name`, `status`, `email`, `is_activated`, `agency_id`) 
	VALUES 
		('1', 'admin', '$2a$08$lDnHPz7eUkSi6ao14Twuau08mzhWrL4kyZGGU5xfiGALO/Vxd5DOi', 'lindo', 'v', 'sebastian', 1, 'admin@gmail.com', 1, null);
SET FOREIGN_KEY_CHECKS=1;

INSERT INTO `jwt`.`user` (`id`, `user_name`, `password`, `first_name`, `middle_name`, `last_name`, `status`, `email`, `is_activated`, `agency_id`) 
	VALUES 
		('2', 'lindo', '', 'lindo', 'v', 'sebastian', 1, 'lindo@gmail.com', 1, 1),
		('3', 'nimmy', '', 'nimmy', 'v', 'lindo', 1, 'nimmy@gmail.com', 1, 1),
		('4', 'nikhil', '', 'nikhil', '', 'baby', 1, 'nikhil@gmail.com', 1, 2),
		('5', 'unni', '', 'unni', '', 'baby', 1, 'unni@gmail.com', 1, 2);

INSERT INTO `jwt`.`address` (`id`, `address1`, `address2`, `city`, `country`, `state`, `zip`, `user_id`, `status`) 
	VALUES
		('1', 'address 1', 'address 2', 'Ernakulam', 'India', 'Kerala', '55025', 1, 1),
		('2', 'address 1', 'address 2', 'Trivandrum', 'India', 'Kerala', '11111', 2, 1);

INSERT INTO `jwt`.`phone` (`id`, `is_primary`, `phone`, `user_id`, `status`) 
	VALUES 
		('1', '1', '713-737-5036', 1, 1), 
		('2', '1', '832-416-4296', 2, 1);

SET FOREIGN_KEY_CHECKS=0;
INSERT INTO `jwt`.`authority` (`id`, `description`, `name`, `agency_id`, `status`) VALUES ('1', 'Super Admin role', 'SAdmin', null, 1);
SET FOREIGN_KEY_CHECKS=1;
	
INSERT INTO `jwt`.`authority` (`id`, `description`, `name`, `agency_id`, `status`) 
	VALUES 
		('2', 'Admin role', 'Admin', 1, 1), 
		('3', 'User role', 'User', 1, 1),
		('4', 'Guest role', 'guest', 1, 1);

insert into user_authority (`user_id`, `authority_id`) 
	values 
		(1,1),
		(2,2), 
		(3,3);

INSERT INTO `jwt`.`permission` (`id`, `permission_name`, `status`) 
	VALUES 
		('1', 'user-add', 1), 
		('2', 'user-update', 1), 
		('3', 'user-view', 1), 
		('4', 'user-delete', 1);
		
insert into role_permissions (`authority_id`, `permission_id`) 
	VALUES 
		(1,1), 
		(1,2), 
		(1,3), 
		(1,4),
		(2,3);


INSERT INTO tb_user(
	email, password, profile, created_at, updated_at)
	VALUES ('admin@jayatech.net.br', '$2a$10$8ubI9YIkIGrJsTUSZDege.J9jnTTMUizHB92c2Y0H4Kc2MUSbxuPy', 'ROLE_USER', NOW() AT TIME ZONE 'utc', NOW() AT TIME ZONE 'utc');
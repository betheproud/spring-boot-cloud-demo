use auth;

create table oauth_client_details (
  client_id VARCHAR(255) PRIMARY KEY,
  resource_ids VARCHAR(255),
  client_secret VARCHAR(255),
  scope VARCHAR(255),
  authorized_grant_types VARCHAR(255),
  web_server_redirect_uri VARCHAR(255),
  authorities VARCHAR(255),
  access_token_validity INTEGER,
  refresh_token_validity INTEGER,
  additional_information VARCHAR(4096),
  autoapprove tinyint
);

create table oauth_client_token (
  token_id VARCHAR(255),
  token BLOB,
  authentication_id VARCHAR(255),
  user_name VARCHAR(255),
  client_id VARCHAR(255)
);

create table oauth_access_token (
  token_id VARCHAR(255),
  token BLOB,
  authentication_id VARCHAR(255),
  user_name VARCHAR(255),
  client_id VARCHAR(255),
  authentication BLOB,
  refresh_token VARCHAR(255)
);

create table oauth_refresh_token (
  token_id VARCHAR(255),
  token BLOB,
  authentication BLOB
);

create table oauth_code (
  code VARCHAR(255), authentication BLOB
);

create table oauth_approvals (
	userId VARCHAR(256),
	clientId VARCHAR(256),
	scope VARCHAR(256),
	status VARCHAR(10),
	expiresAt TIMESTAMP,
	lastModifiedAt TIMESTAMP
);

INSERT INTO `oauth_client_details` (`client_id`, `resource_ids`, `client_secret`, `scope`, `authorized_grant_types`, `web_server_redirect_uri`, `authorities`, `access_token_validity`, `refresh_token_validity`, `additional_information`, `autoapprove`)
VALUES ('client', 'oauth2-resource', 'fae7fb00d2e6237cb23d304b193feecd', 'read', 'authorization_code,password,refresh_token,implicit', null, 'ROLE_CLIENT, ROLE_TRUSTED_CLIENT', 900, null, '{}', null);

INSERT INTO `oauth_client_details` (`client_id`, `resource_ids`, `client_secret`, `scope`, `authorized_grant_types`, `web_server_redirect_uri`, `authorities`, `access_token_validity`, `refresh_token_validity`, `additional_information`, `autoapprove`)
VALUES ('trust_client', 'oauth2-resource', '86d7851971c4e8f384fd345fb05c4eae', 'read,write,trust', 'authorization_code,password,refresh_token,implicit', null, 'ROLE_CLIENT, ROLE_TRUSTED_CLIENT', 900, null, '{}', null);


CREATE TABLE `member` (
  `id` BIGINT(11) NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(150) NOT NULL,
  PRIMARY KEY (`id`)
);


INSERT INTO `member` (`username`, `password`) VALUES ('member1', '$2a$10$0Bpq4Nwm2zxj9x5ppWZxmuX92cF7f10uT6TNRUumRvvLAuvWL2B4i');
INSERT INTO `member` (`username`, `password`) VALUES ('member2', '$2a$10$lqseWhdABGjy56Rx6cv3d.oSoP0dYGyjnKP/glLAbn2AyWfDiL8Wi');
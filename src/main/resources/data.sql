DELETE FROM `tbl_account` WHERE email = 'nonAuth@test.com';

INSERT INTO `tbl_account` (`id`, `created_date`, `modified_date`, `access_token`, `email`, `is_auth`, `password`, `platform_type`, `profile_image`, `refresh_token`, `role`, `user_name`, `recv_mail`) VALUES
(139, '2021-06-29 00:38:48', '2021-06-29 00:38:48', NULL, 'nonAuth@test.com', 0, '{bcrypt}$2a$44$FDGXyWFxt5HteROYu6cxIeHqvpIA4c5pxEHKq.2yor.XEnHT92yjS', 'RLOG', 'https://rlog.or.kr/assets/img/illustrations/profiles/profile-2.png', NULL, 'USER', '미인증 사용자', 0);

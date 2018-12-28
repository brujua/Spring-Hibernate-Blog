create table posts (
  id          bigint    not null,
  created_on  timestamp not null,
  modified_on timestamp not null,
  title      varchar(255),
  content    varchar(2600),
  id_user   bigint  not null,
  primary key (id)
);

create table users (
 id		bigint		not null,
  created_on	timestamp	not null,
  modified_on	timestamp	not null,
  name	varchar(64)	not null,
  mail      	varchar(255)	not null,
  pass	varchar(128)	not null,
  primary key (id)

);

create table comments (
  id		bigint		not null,
  created_on	timestamp	not null,
  modified_on	timestamp	not null,
  content      	varchar(1200)	not null,
  id_user bigint not null,
  id_post bigint not null,
  primary key (id)
);

create table tags (
  id bigint not null,
  name varchar(32) not null,
  primary key (id)
);

create table post_tag(
  id_post bigint not null,
  id_tag bigint not null,
  primary key (id_post,id_tag)
);

alter table tags
  add constraint UK_tags_tag unique (name);

alter table posts
  add constraint FK_posts foreign key (id_user) references users;

alter table comments
  add constraint FK_comments_user foreign key (id_user) references users;

alter table comments
  add constraint FK_comments_post foreign key (id_post) references posts;

alter table post_tag
  add constraint FK_post_tag_id_post foreign key (id_post) references posts;

alter table post_tag
  add constraint FK_post_tag_id_tag foreign key (id_tag) references tags;

create sequence hibernate_sequence
  start with 100
  increment by 1;




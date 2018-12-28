insert into users (id, mail, name, pass, created_on, modified_on)
values (1,'brunocrisafulli@hotmail.com','bruno','123456','2018-12-07 21:14:32', '2018-12-07 21:14:32'),
       (2,'jorgito205@gmail.com','jorgito',565656,'2018-12-07 21:14:32', '2018-12-07 21:14:32');

insert into tags (id, name)
values (1,'sports'),
       (2,'real life'),
       (3,'gaming');


/*Each user has one post*/
insert into posts (id,title,content,id_user,created_on, modified_on)
values (1,'Mi new bicycle','I want to show you the bicycle that i bought yesterday on the local store. It has everything i need for my weekend adventures, Hog Mountain see ya soon!',1,'2018-12-07 21:14:32', '2018-12-07 21:14:32' ),
       (2,'Constructor Entrepreneur II rocks!', 'I have recently come upon this sequel and i have to say that i am amazed. ' ||
        'I had played the first one in my youth and being back in the building business revives ' ||
         'so much nostalgic memories. Do not miss the chance to try it, specially if you played the first one back in the days.',
         2,'2018-12-07 21:14:32', '2018-12-07 21:14:32');



insert into post_tag (id_post,id_tag)
values (1,2), /* First post tag: 'real life' */
       (2,3); /* Second post tag: 'gaming' */

insert into comments (id, content, id_user, id_post,created_on, modified_on)
values (),
       ();
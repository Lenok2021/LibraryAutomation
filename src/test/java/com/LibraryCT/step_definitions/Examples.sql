-- user story 1
select count(ID)
from users;


-- user story 1
select *
from users;

select count(id) from users ;

-- user story 2
select count(*)
from book_borrow
where is_returned = 0;

-- user story3
select bc.name, count(*)
from book_borrow bb
         inner join books b on bb.book_id = b.id
         inner join book_categories bc on b.book_category_id = bc.id
group by name
order by 2 desc


(:*******************************************************:)
(: Test: K-SeqIndexOfFunc-22                             :)
(: Written by: Frans Englich                             :)
(: Date: 2006-10-05T18:29:40+02:00                       :)
(: Purpose: A test whose essence is: `count(index-of((1, 2, 3, 2, 1), 2)) eq 2`. :)
(:*******************************************************:)
count(index-of((1, 2, 3, 2, 1), 2)) eq 2
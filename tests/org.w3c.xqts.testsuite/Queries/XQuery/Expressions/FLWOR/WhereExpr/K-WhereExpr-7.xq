(:*******************************************************:)
(: Test: K-WhereExpr-7                                   :)
(: Written by: Frans Englich                             :)
(: Date: 2006-10-05T18:29:37+02:00                       :)
(: Purpose: A for expression binding to one single value, combined with a positive where clause. :)
(:*******************************************************:)
empty(for $i in 1 where (1, current-time())[1] treat as xs:integer eq 0 return $i)
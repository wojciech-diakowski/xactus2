(:*******************************************************:)
(: Test: K-WhereExpr-11                                  :)
(: Written by: Frans Englich                             :)
(: Date: 2006-10-05T18:29:37+02:00                       :)
(: Purpose: A for/where expression combined with fn:boolean and xs:anyURI. :)
(:*******************************************************:)
empty(for $i in (1, 2, current-time())[1] where xs:anyURI("") return true())
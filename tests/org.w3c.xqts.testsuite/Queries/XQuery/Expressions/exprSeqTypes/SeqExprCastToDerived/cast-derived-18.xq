(: name : cast-derived-18 :)
(: description : Casting from double to a long.:)

(: insert-start :)
declare variable $input-context1 external;
(: insert-end :)

let $value := xs:double(10E2)
return $value cast as xs:long
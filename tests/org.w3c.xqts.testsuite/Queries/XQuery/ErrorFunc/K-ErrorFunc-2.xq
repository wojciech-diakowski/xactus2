(:*******************************************************:)
(: Test: K-ErrorFunc-2                                   :)
(: Written by: Frans Englich                             :)
(: Date: 2006-10-05T18:29:39+02:00                       :)
(: Purpose: A test whose essence is: `if(true()) then true() else error(QName("", "local"), "description")`. :)
(:*******************************************************:)
if(true()) then true() else 
						error(QName("", "local"), "description")
(:*******************************************************:)
(:Test: adjust-date-to-timezone-18                       :)
(:Written By: Carmelo Montanez                           :)
(:Date: August 10, 2005                                  :)
(:Test Description: Evaluates The "adjust-date-to-timezone" function   :)
(:as part of a subtraction expression, which results on a negative number.:)
(:Uses one adjust-date-to-timezone function and one      :)
(:xs:date constructor.                                   :)
(:*******************************************************:)
let $tz := xs:dayTimeDuration("PT10H")
return
fn:adjust-date-to-timezone(xs:date("2002-03-07Z"),$tz) - xs:date("2006-03-07Z")
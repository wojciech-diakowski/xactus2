(:*******************************************************:)
(:Test: op-add-yearMonthDuration-to-dateTime-3           :)
(:date: July 5, 2005                                     :)
(:Purpose: Evaluates The string value of "add-yearMonthDuration-to-dateTime" :)
(: operator as part of a boolean expression (or operator) and the "fn:boolean" :)
(: function. :)
(:*******************************************************:)
 
fn:string((xs:dateTime("1999-10-23T13:45:45Z") + xs:yearMonthDuration("P19Y12M"))) or fn:false()
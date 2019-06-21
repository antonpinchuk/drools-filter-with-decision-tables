Using Drools decision tables to filter item list
================================================

One of our business tasks is to apply 20+ complex decision rules and filter only
records which match all of them. Passing each rule the records are being shortlisted.
~~~
Rule #           1      2      3     4   ...   20
Items count   2.1M   967K   281K   35K   ...   16
~~~

The approach is to do to this cut in ACTION section of decision table.

In this sample project you can find example of using .xls decision tables with Drools.

To try it you will need to populate decision table [here](https://github.com/antonpinchuk/drools-filter-with-decision-tables/tree/master/src/main/resources/rules) templates with some real data.
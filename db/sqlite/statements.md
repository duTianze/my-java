# SELECT

## Simple uses of SELECT statement

```shell
SELECT
	1 + 13;

SELECT
	10 / 5,
	2 * 4 ;
```

### Querying data from a table using the SELECT statement

```shell
SELECT DISTINCT column_list
FROM table_list
  JOIN table ON join_condition
WHERE row_filter
ORDER BY column
LIMIT count OFFSET offset
GROUP BY column
HAVING group_filter;
```

### Select basic

```shell
# get part columns from table
SELECT
	trackid,
	name,
	composer,
	unitprice
FROM
	tracks;
## get all columns from table
```

# Order By

```shell
SELECT
   select_list
FROM
   table
ORDER BY
    column_1 ASC,
    column_2 DESC;
```

## sort the result set based on AlbumId column in ascending order

```shell
SELECT
	name,
	milliseconds, 
	albumid
FROM
	tracks
ORDER BY
	albumid ASC;
# default is ASC
```

![](.statements_images/2c8837c1.png)

## sort the sorted result (by AlbumId) above by the Milliseconds column in descending order

```shell
SELECT
	name,
	milliseconds, 
	albumid
FROM
	tracks
ORDER BY
	albumid ASC;
```

![](.statements_images/d2d47838.png)

## SQLite ORDER BY with the column position

the following statement sorts the tracks by both albumid (3rd column) and milliseconds (2nd column) in ascending order.

```shell
SELECT
	name,
	milliseconds, 
	albumid
FROM
	tracks
ORDER BY
	 3,2;
```

![](.statements_images/76c7b1ca.png)

## Sorting NULLs

When it comes to sorting, SQLite considers NULL to be `smaller` than any other value.

SQLite 3.30.0 added the `NULLS FIRST` and `NULLS LAST` options to the `ORDER BY` clause. The `NULLS FIRST` option
specifies that the NULLs will appear at the beginning of the result set while the `NULLS LAST` option place NULLs at the
end of the result set.

The following example uses the ORDER BY clause to sort tracks by composers:

First, you see that NULLs appear at the beginning of the result set because SQLite treats them as the lowest values.
When you scroll down the result, you will see other values:

```shell
SELECT
	TrackId,
	Name,
	Composer
FROM
	tracks
ORDER BY
	Composer ;
```

![](.statements_images/b4e0bc89.png)

The following example uses the NULLS LAST option to place NULLs after other values:

If you scroll down the output, you will see that NULLs are placed at the end of the result set:
![](.statements_images/28d8de4c.png)

# DISTINCT

The `DISTINCT` clause allows you to remove the duplicate rows in the result set.

SQLite considers NULL values as duplicates. If you use theDISTINCT clause with a column that has NULL values, SQLite
will keep one row of a NULL value.

```shell
SELECT DISTINCT	select_list
FROM table;
```

## SELECT DISTINCT on one column

Suppose you want to know the cities where the customers locate, you can use the SELECT statement to get data from the
city column of the customers table as follows:

```shell
SELECT city
FROM customers
ORDER BY city;
```

![](.statements_images/0f56e283.png)
It returns 59 rows. There are few duplicate rows such as Berlin London, and Mountain View To remove these duplicate
rows, you use the DISTINCT clause as follows:

```shell
SELECT
	DISTINCT city
FROM
	customers
ORDER BY
	city;
```

![](.statements_images/3ed526a8.png)

## SELECT DISTINCT on multiple columns

The following statement finds cities and countries of all customers.

![](.statements_images/f9b1dfa0.png)

The result set contains duplicate city and country e.g., Sao Paulo in Brazil as shown in the screenshot above.

To remove duplicate the city and country, you apply the DISTINCT clause to both city and country columns as shown in the
following query:

```shell
SELECT
	DISTINCT 
	city,
	country
FROM
	customers
ORDER BY
	country;
```

![](.statements_images/42551dc4.png)

# WHERE

```shell
SELECT
	column_list
FROM
	table
WHERE
	search_condition;
	
search_condition: left_expression COMPARISON_OPERATOR right_expression
eg.
WHERE column_1 = 100;

WHERE column_2 IN (1,2,3);

WHERE column_3 LIKE 'An%';

WHERE column_4 BETWEEN 10 AND 20;
```

## comparison operator

A comparison operator tests if two expressions are the same. The following table illustrates the comparison operators
that you can use to construct expressions:

|  Operator   | Meaning  |
|  ----  | ----  |
| =  | Equal to |
| <> or !=  | Not equal to |
| < | Less than |
| \> | Greater than |
| <= | Less than or equal to |
| > = | Greater than or equal to |

the following query uses the WHERE clause the equality operator to find all the tracks in the album id 1:

```shell
SELECT
	name,
	milliseconds,
	bytes,
	albumid
FROM
	tracks
WHERE
	albumid = 1;
```

## logical operators

| Operator                                                  | Meaning                                                                             |
| ----------------------------------------------------------- | ------------------------------------------------------------------------------------- |
| ALL                                                       | returns 1 if all expressions are 1.                                                 |
| AND                                                       | returns 1 if both expressions are 1, and 0 if one of the expressions is 0.          |
| ANY                                                       | returns 1 if any one of a set of comparisons is 1.                                  |
| BETWEEN | returns 1 if a value is within a range.         |
| EXISTS   | returns 1 if a subquery contains any rows.     |
| IN        | returns 1 if a value is in a list of values.  |
| LIKE       | returns 1 if a value matches a pattern       |
| NOT                                                       | reverses the value of other operators such as NOT EXISTS, NOT IN, NOT BETWEEN, etc. |
| OR                                                        | returns true if either expression is 1                                              |

get tracks of the album 1 that have the length greater than 200,000 milliseconds, you use the following statement:

```shell
SELECT
	name,
	milliseconds,
	bytes,
	albumid
FROM
	tracks
WHERE
	albumid = 1
	AND milliseconds > 200000;
```

## LIKE operator

find which tracks composed by Smith, you use the LIKE operator as follows:

```shell
SELECT
	name,
	albumid,
	composer
FROM
	tracks
WHERE
	composer LIKE '%Smith%'
ORDER BY
	albumid;
	
```

## IN operator

ind tracks that have media type id is 2 or 3, you use the IN operator as shown in the following statement:

```shell
SELECT
	name,
	albumid,
	mediatypeid
FROM
	tracks
WHERE
	mediatypeid IN (2, 3);
```
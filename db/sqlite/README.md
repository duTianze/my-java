# SQLite

[SQLite](http://www.sqlite.org/) - A completely embedded, full-featured relational database in a few 100k that you can
include right into your project.

## tutorial

https://www.sqlitetutorial.net/

## What is SQLite

SQLite is a software library that provides a relational database management system. The lite in SQLite means lightweight
in terms of setup, database administration, and required resources.

SQLite has the following noticeable features: self-contained, serverless, zero-configuration, transactional.

### Serverless

Normally, an RDBMS such as MySQL, PostgreSQL, etc., requires a separate server process to operate. The applications that
want to access the database server use TCP/IP protocol to send and receive requests. This is called client/server
architecture.

The following diagram illustrates the RDBMS client/server architecture:

![](.README_images/ac1086b0.png)

SQLite does NOT work this way.

SQLite does NOT require a server to run.

SQLite database is integrated with the application that accesses the database. The applications interact with the SQLite
database read and write directly from the database files stored on disk.

The following diagram illustrates the SQLite server-less architecture:

![](.README_images/f578185b.png)

### Self-Contained

SQLite is self-contained means it requires minimal support from the operating system or external library. This makes
SQLite usable in any environment especially in embedded devices like iPhones, Android phones, game consoles, handheld
media players, etc.

SQLite is developed using ANSI-C. The source code is available as a big sqlite3.c and its header file sqlite3.h. If you
want to develop an application that uses SQLite, you just need to drop these files into your project and compile it with
your code.

### Zero-configuration

Because of the serverless architecture, you don’t need to “install” SQLite before using it. There is no server process
that needs to be configured, started, and stopped.

In addition, SQLite does not use any configuration files.

### Transactional

All transactions in SQLite are fully ACID-compliant. It means all queries and changes are Atomic, Consistent, Isolated,
and Durable.

In other words, all changes within a transaction take place completely or not at all even when an unexpected situation
like application crash, power failure, or operating system crash occurs.

## SQLite distinctive features

SQLite uses dynamic types for tables. It means you can store any value in any column, regardless of the data type.

SQLite allows a single database connection to access multiple database files simultaneously. This brings many nice
features like joining tables in different databases or copying data between databases in a single command.

SQLite is capable of creating in-memory databases that are very fast to work with.

## References

1. [https://www.sqlite.org](https://www.sqlite.org/) – SQLite homepage
2. [https://www.sqlite.org/features.html](https://www.sqlite.org/features.html) – SQLite features
3. [https://www.sqlite.org/copyright.html](https://www.sqlite.org/copyright.html) – SQLite license
4. [https://www.sqlite.org/docs.html](https://www.sqlite.org/docs.html) – SQLite documentation

## Download SQLite tools

To download SQLite, you open the [download page](https://www.sqlite.org/download.html) of the SQlite official website.

### official

1. First, go to the [https://www.sqlite.org](https://www.sqlite.org/) website.
2. Second, open the download page [https://www.sqlite.org/download.html](https://www.sqlite.org/download.html)

SQLite provides various tools for working across platforms e.g., Windows, Linux, and Mac. You need to select an
appropriate version to download.

### homebrew

```shell
 brew install sqlite
```

## Run SQLite tools

1. type `sqlite3` and press enter, you should see the following output:

```shell
» sqlite3 
SQLite version 3.37.0 2021-12-09 01:34:53
Enter ".help" for usage hints.
Connected to a transient in-memory database.
Use ".open FILENAME" to reopen on a persistent database.
```

2. type the `.help` command from the sqlite> prompt to see all available commands in sqlite3.

```shell
sqlite> .help
.auth ON|OFF             Show authorizer callbacks
.backup ?DB? FILE        Backup DB (default "main") to FILE
.bail on|off             Stop after hitting an error.  Default OFF
.binary on|off           Turn binary output on or off.  Default OFF
.cd DIRECTORY            Change the working directory to DIRECTORY
```

3. to quit the sqlite>, you use `.quit` command as follows:

```shell
sqlite> .quit
```

## Install SQLite GUI tool

The sqlite3 shell is excellent…

However, sometimes, you may want to work with the SQLite databases using an intuitive GUI tool.

There are many GUI tools for managing SQLite databases available ranging from freeware to commercial licenses.

- [DBeaver](https://dbeaver.io/) is a free multi-platform database tool. It supports all popular major relational
  database systems MySQL, PostgreSQL, Oracle, DB2, SQL Server, Sybase.. including SQLite.

```shell
 brew install --cask dbeaver-community 
```

## SQLite Sample Database

![](.README_images/04ea3b1a.png)

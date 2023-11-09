USE [master]
GO
CREATE DATABASE [bookory]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'bookory', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL16.NHOM8CSDLPT\MSSQL\DATA\bookory.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'bookory_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL16.NHOM8CSDLPT\MSSQL\DATA\bookory_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT, LEDGER = OFF
GO
ALTER DATABASE [bookory] SET COMPATIBILITY_LEVEL = 160
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [bookory].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [bookory] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [bookory] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [bookory] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [bookory] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [bookory] SET ARITHABORT OFF 
GO
ALTER DATABASE [bookory] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [bookory] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [bookory] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [bookory] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [bookory] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [bookory] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [bookory] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [bookory] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [bookory] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [bookory] SET  DISABLE_BROKER 
GO
ALTER DATABASE [bookory] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [bookory] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [bookory] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [bookory] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [bookory] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [bookory] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [bookory] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [bookory] SET RECOVERY FULL 
GO
ALTER DATABASE [bookory] SET  MULTI_USER 
GO
ALTER DATABASE [bookory] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [bookory] SET DB_CHAINING OFF 
GO
ALTER DATABASE [bookory] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [bookory] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [bookory] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [bookory] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
EXEC sys.sp_db_vardecimal_storage_format N'bookory', N'ON'
GO
ALTER DATABASE [bookory] SET QUERY_STORE = ON
GO
ALTER DATABASE [bookory] SET QUERY_STORE (OPERATION_MODE = READ_WRITE, CLEANUP_POLICY = (STALE_QUERY_THRESHOLD_DAYS = 30), DATA_FLUSH_INTERVAL_SECONDS = 900, INTERVAL_LENGTH_MINUTES = 60, MAX_STORAGE_SIZE_MB = 1000, QUERY_CAPTURE_MODE = AUTO, SIZE_BASED_CLEANUP_MODE = AUTO, MAX_PLANS_PER_QUERY = 200, WAIT_STATS_CAPTURE_MODE = ON)
GO
USE [bookory]
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Account](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[username] [nvarchar](100) NULL,
	[email] [nvarchar](100) NULL,
	[userrole] [nvarchar](10) NULL,
	[pass] [nvarchar](20) NULL,
	[avatar] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY],
UNIQUE NONCLUSTERED 
(
	[email] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Book](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[title] [nvarchar](100) NULL,
	[slug] [nvarchar](100) NULL,
	[author] [nvarchar](100) NULL,
	[description] [text] NULL,
	[price] [real] NULL,
	[release] [date] NULL,
	[pages] [int] NULL,
	[category] [nvarchar](50) NULL,
	[stars] [real] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY],
UNIQUE NONCLUSTERED 
(
	[slug] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[BookCover](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[slug] [nvarchar](100) NOT NULL,
	[fname] [nvarchar](100) NULL,
	[ftype] [nvarchar](100) NULL,
	[filepath] [nvarchar](256) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC,
	[slug] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY],
UNIQUE NONCLUSTERED 
(
	[slug] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Cart](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[bookid] [int] NULL,
	[userid] [int] NULL,
	[quantity] [int] NULL,
	[status] [nvarchar](100) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Comment](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[bookid] [int] NULL,
	[userid] [int] NULL,
	[rate] [real] NULL,
	[content] [text] NULL,
	[timeup] [date] NULL
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Purchase](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[orderid] [nvarchar](100) NULL,
	[status] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY],
UNIQUE NONCLUSTERED 
(
	[orderid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[BookCover]  WITH CHECK ADD FOREIGN KEY([slug])
REFERENCES [dbo].[Book] ([slug])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[Cart]  WITH CHECK ADD FOREIGN KEY([bookid])
REFERENCES [dbo].[Book] ([id])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[Cart]  WITH CHECK ADD FOREIGN KEY([userid])
REFERENCES [dbo].[Account] ([id])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[Comment]  WITH CHECK ADD FOREIGN KEY([bookid])
REFERENCES [dbo].[Book] ([id])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[Comment]  WITH CHECK ADD FOREIGN KEY([userid])
REFERENCES [dbo].[Account] ([id])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
USE [master]
GO
ALTER DATABASE [bookory] SET  READ_WRITE 
GO

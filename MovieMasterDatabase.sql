USE [master]
GO
/****** Object:  Database [MovieMaster]    Script Date: 10/28/2023 9:34:23 AM ******/
CREATE DATABASE [MovieMaster]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'MovieMaster', FILENAME = N'E:\Sql Server\MSSQL13.MSSQLSERVER\MSSQL\DATA\MovieMaster.ndf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'MovieMaster_log', FILENAME = N'E:\Sql Server\MSSQL13.MSSQLSERVER\MSSQL\DATA\MovieMaster_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
GO
ALTER DATABASE [MovieMaster] SET COMPATIBILITY_LEVEL = 130
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [MovieMaster].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [MovieMaster] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [MovieMaster] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [MovieMaster] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [MovieMaster] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [MovieMaster] SET ARITHABORT OFF 
GO
ALTER DATABASE [MovieMaster] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [MovieMaster] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [MovieMaster] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [MovieMaster] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [MovieMaster] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [MovieMaster] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [MovieMaster] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [MovieMaster] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [MovieMaster] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [MovieMaster] SET  ENABLE_BROKER 
GO
ALTER DATABASE [MovieMaster] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [MovieMaster] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [MovieMaster] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [MovieMaster] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [MovieMaster] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [MovieMaster] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [MovieMaster] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [MovieMaster] SET RECOVERY FULL 
GO
ALTER DATABASE [MovieMaster] SET  MULTI_USER 
GO
ALTER DATABASE [MovieMaster] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [MovieMaster] SET DB_CHAINING OFF 
GO
ALTER DATABASE [MovieMaster] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [MovieMaster] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [MovieMaster] SET DELAYED_DURABILITY = DISABLED 
GO
EXEC sys.sp_db_vardecimal_storage_format N'MovieMaster', N'ON'
GO
ALTER DATABASE [MovieMaster] SET QUERY_STORE = OFF
GO
USE [MovieMaster]
GO
ALTER DATABASE SCOPED CONFIGURATION SET LEGACY_CARDINALITY_ESTIMATION = OFF;
GO
ALTER DATABASE SCOPED CONFIGURATION SET MAXDOP = 0;
GO
ALTER DATABASE SCOPED CONFIGURATION SET PARAMETER_SNIFFING = ON;
GO
ALTER DATABASE SCOPED CONFIGURATION SET QUERY_OPTIMIZER_HOTFIXES = OFF;
GO
USE [MovieMaster]
GO
/****** Object:  Table [dbo].[movie]    Script Date: 10/28/2023 9:34:23 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[movie](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Imdbid] [varchar](255) NULL,
	[Actors] [varchar](255) NULL,
	[Awards] [varchar](255) NULL,
	[Box_office] [varchar](255) NULL,
	[Country] [varchar](255) NULL,
	[Dvd] [varchar](255) NULL,
	[Director] [varchar](255) NULL,
	[Genre] [varchar](255) NULL,
	[language] [varchar](255) NULL,
	[Metascore] [varchar](255) NULL,
	[Plot] [varchar](255) NULL,
	[Poster] [varchar](255) NULL,
	[Production] [varchar](255) NULL,
	[Rated] [varchar](255) NULL,
	[Released] [varchar](255) NULL,
	[Response] [varchar](255) NULL,
	[Runtime] [varchar](255) NULL,
	[Title] [varchar](255) NULL,
	[Type] [varchar](255) NULL,
	[Website] [varchar](255) NULL,
	[Writer] [varchar](255) NULL,
	[Year] [varchar](255) NULL,
	[Imdb_rating] [varchar](255) NULL,
	[Imdb_votes] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[oscar_winner]    Script Date: 10/28/2023 9:34:23 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[oscar_winner](
	[Title] [varchar](255) NULL,
	[Year] [varchar](255) NULL,
	[Category] [varchar](255) NULL,
	[Id] [int] IDENTITY(1,1) NOT NULL,
 CONSTRAINT [PK__oscar_wi__3214EC27D8FEB935] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY],
 CONSTRAINT [UK2nikvjn12immt5rblui0cek72] UNIQUE NONCLUSTERED 
(
	[Title] ASC,
	[Year] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
USE [master]
GO
ALTER DATABASE [MovieMaster] SET  READ_WRITE 
GO

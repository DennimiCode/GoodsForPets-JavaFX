USE [GoodsForPets]
GO
/****** Object:  Table [dbo].[Addresses]    Script Date: 01/07/2023 20:22:19 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Addresses](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[City] [nvarchar](max) NOT NULL,
	[Street] [nvarchar](300) NOT NULL,
 CONSTRAINT [PK_Addresses] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[BaseMaterials]    Script Date: 01/07/2023 20:22:20 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[BaseMaterials](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](200) NOT NULL,
	[Unit] [nvarchar](20) NOT NULL,
 CONSTRAINT [PK_BaseMaterials] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Categories]    Script Date: 01/07/2023 20:22:20 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Categories](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](200) NOT NULL,
	[Unit] [nvarchar](20) NOT NULL,
 CONSTRAINT [PK_Categories] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[GrocerySets]    Script Date: 01/07/2023 20:22:20 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[GrocerySets](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[ProductId] [nvarchar](100) NOT NULL,
	[SubProductId] [nvarchar](100) NOT NULL,
 CONSTRAINT [PK_GrocerySets] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Locations]    Script Date: 01/07/2023 20:22:20 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Locations](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[PostCode] [int] NOT NULL,
	[HouseNumber] [int] NOT NULL,
	[AddressId] [int] NOT NULL,
 CONSTRAINT [PK_Locations] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Manufacturers]    Script Date: 01/07/2023 20:22:20 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Manufacturers](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](max) NOT NULL,
 CONSTRAINT [PK_Manufacturers] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Mixtures]    Script Date: 01/07/2023 20:22:20 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Mixtures](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[BaseMaterialId] [int] NOT NULL,
	[RawMaterialId] [int] NOT NULL,
 CONSTRAINT [PK_Mixtures] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[OrderProducts]    Script Date: 01/07/2023 20:22:20 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[OrderProducts](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[ProductAmount] [int] NOT NULL,
	[OrderId] [int] NOT NULL,
	[ProductId] [nvarchar](100) NOT NULL,
 CONSTRAINT [PK_OrderProducts] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Orders]    Script Date: 01/07/2023 20:22:20 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Orders](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Status] [nvarchar](max) NOT NULL,
	[OrderDate] [datetime2](7) NOT NULL,
	[DeliveryDate] [datetime2](7) NOT NULL,
	[LocationId] [int] NOT NULL,
	[UserId] [int] NOT NULL,
 CONSTRAINT [PK_Orders] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Products]    Script Date: 01/07/2023 20:22:20 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Products](
	[Id] [nvarchar](100) NOT NULL,
	[Name] [nvarchar](max) NOT NULL,
	[Cost] [float] NOT NULL,
	[MaxDiscountAmount] [int] NOT NULL,
	[CurrentDiscountAmount] [int] NOT NULL,
	[QuantityInStock] [int] NOT NULL,
	[Description] [nvarchar](max) NOT NULL,
	[Photo] [nvarchar](max) NULL,
	[ProductInfoId] [int] NOT NULL,
 CONSTRAINT [PK_Products] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ProductsInfo]    Script Date: 01/07/2023 20:22:20 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ProductsInfo](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[CategoryId] [int] NOT NULL,
	[ManufacturerId] [int] NOT NULL,
	[SupplierId] [int] NOT NULL,
 CONSTRAINT [PK_ProductsInfo] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[RawMaterials]    Script Date: 01/07/2023 20:22:20 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[RawMaterials](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](200) NOT NULL,
	[Unit] [nvarchar](20) NOT NULL,
 CONSTRAINT [PK_RawMaterials] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Roles]    Script Date: 01/07/2023 20:22:20 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Roles](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](100) NOT NULL,
 CONSTRAINT [PK_Roles] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[SubProducts]    Script Date: 01/07/2023 20:22:20 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SubProducts](
	[Id] [nvarchar](100) NOT NULL,
	[Name] [nvarchar](max) NOT NULL,
	[Cost] [float] NOT NULL,
	[MaxDiscountAmount] [int] NOT NULL,
	[CurrentDiscountAmount] [int] NOT NULL,
	[QuantityInStock] [int] NOT NULL,
	[Description] [nvarchar](max) NOT NULL,
	[Photo] [nvarchar](max) NOT NULL,
	[BaseMaterialId] [int] NOT NULL,
	[ProductInfoId] [int] NOT NULL,
 CONSTRAINT [PK_SubProducts] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Suppliers]    Script Date: 01/07/2023 20:22:20 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Suppliers](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](max) NOT NULL,
 CONSTRAINT [PK_Suppliers] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Users]    Script Date: 01/07/2023 20:22:20 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Users](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](100) NOT NULL,
	[Surname] [nvarchar](100) NOT NULL,
	[Patronymic] [nvarchar](100) NOT NULL,
	[Login] [nvarchar](max) NOT NULL,
	[Password] [nvarchar](max) NOT NULL,
	[RoleId] [int] NOT NULL,
 CONSTRAINT [PK_Users] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[Addresses] ON 

INSERT [dbo].[Addresses] ([Id], [City], [Street]) VALUES (1, N'Нефтеюганск', N'Чехова')
INSERT [dbo].[Addresses] ([Id], [City], [Street]) VALUES (2, N'Нефтеюганск', N'Степная')
INSERT [dbo].[Addresses] ([Id], [City], [Street]) VALUES (3, N'Нефтеюганск', N'Коммунистическая')
INSERT [dbo].[Addresses] ([Id], [City], [Street]) VALUES (4, N'Нефтеюганск', N'Солнечная')
INSERT [dbo].[Addresses] ([Id], [City], [Street]) VALUES (5, N'Нефтеюганск', N'Шоссейная')
INSERT [dbo].[Addresses] ([Id], [City], [Street]) VALUES (6, N'Нефтеюганск', N'Партизанская')
INSERT [dbo].[Addresses] ([Id], [City], [Street]) VALUES (7, N'Нефтеюганск', N'Победы')
INSERT [dbo].[Addresses] ([Id], [City], [Street]) VALUES (8, N'Нефтеюганск', N'Молодежная')
INSERT [dbo].[Addresses] ([Id], [City], [Street]) VALUES (9, N'Нефтеюганск', N'Новая')
INSERT [dbo].[Addresses] ([Id], [City], [Street]) VALUES (10, N'Нефтеюганск', N'Октябрьская')
INSERT [dbo].[Addresses] ([Id], [City], [Street]) VALUES (11, N'Нефтеюганск', N'Садовая')
INSERT [dbo].[Addresses] ([Id], [City], [Street]) VALUES (12, N'Нефтеюганск', N'Комсомольская')
INSERT [dbo].[Addresses] ([Id], [City], [Street]) VALUES (13, N'Нефтеюганск', N'Дзержинского')
INSERT [dbo].[Addresses] ([Id], [City], [Street]) VALUES (14, N'Нефтеюганск', N'Набережная')
INSERT [dbo].[Addresses] ([Id], [City], [Street]) VALUES (15, N'Нефтеюганск', N'Фрунзе')
INSERT [dbo].[Addresses] ([Id], [City], [Street]) VALUES (16, N'Нефтеюганск', N'Школьная')
INSERT [dbo].[Addresses] ([Id], [City], [Street]) VALUES (17, N'Нефтеюганск', N'8 Марта')
INSERT [dbo].[Addresses] ([Id], [City], [Street]) VALUES (18, N'Нефтеюганск', N'Зеленая')
INSERT [dbo].[Addresses] ([Id], [City], [Street]) VALUES (19, N'Нефтеюганск', N'Маяковского')
INSERT [dbo].[Addresses] ([Id], [City], [Street]) VALUES (20, N'Нефтеюганск', N'Светлая')
INSERT [dbo].[Addresses] ([Id], [City], [Street]) VALUES (21, N'Нефтеюганск', N'Цветочная')
INSERT [dbo].[Addresses] ([Id], [City], [Street]) VALUES (22, N'Нефтеюганск', N'Спортивная')
INSERT [dbo].[Addresses] ([Id], [City], [Street]) VALUES (23, N'Нефтеюганск', N'Гоголя')
INSERT [dbo].[Addresses] ([Id], [City], [Street]) VALUES (24, N'Нефтеюганск', N'Северная')
INSERT [dbo].[Addresses] ([Id], [City], [Street]) VALUES (25, N'Нефтеюганск', N'Вишневая')
INSERT [dbo].[Addresses] ([Id], [City], [Street]) VALUES (26, N'Нефтеюганск', N'Подгорная')
INSERT [dbo].[Addresses] ([Id], [City], [Street]) VALUES (27, N'Нефтеюганск', N'Полевая')
INSERT [dbo].[Addresses] ([Id], [City], [Street]) VALUES (28, N'Нефтеюганск', N'Клубная')
INSERT [dbo].[Addresses] ([Id], [City], [Street]) VALUES (29, N'Нефтеюганск', N'Некрасова')
INSERT [dbo].[Addresses] ([Id], [City], [Street]) VALUES (30, N'Нефтеюганск', N'Мичурина')
SET IDENTITY_INSERT [dbo].[Addresses] OFF
GO
SET IDENTITY_INSERT [dbo].[Categories] ON 

INSERT [dbo].[Categories] ([Id], [Name], [Unit]) VALUES (1, N'Для животных', N'шт.')
INSERT [dbo].[Categories] ([Id], [Name], [Unit]) VALUES (2, N'Товары для кошек', N'шт.')
INSERT [dbo].[Categories] ([Id], [Name], [Unit]) VALUES (3, N'Товары для собак', N'шт.')
INSERT [dbo].[Categories] ([Id], [Name], [Unit]) VALUES (1002, N'Товары для птиц', N'шт.')
SET IDENTITY_INSERT [dbo].[Categories] OFF
GO
SET IDENTITY_INSERT [dbo].[Locations] ON 

INSERT [dbo].[Locations] ([Id], [PostCode], [HouseNumber], [AddressId]) VALUES (1, 344288, 1, 1)
INSERT [dbo].[Locations] ([Id], [PostCode], [HouseNumber], [AddressId]) VALUES (2, 614164, 30, 2)
INSERT [dbo].[Locations] ([Id], [PostCode], [HouseNumber], [AddressId]) VALUES (3, 394242, 43, 3)
INSERT [dbo].[Locations] ([Id], [PostCode], [HouseNumber], [AddressId]) VALUES (4, 660540, 25, 4)
INSERT [dbo].[Locations] ([Id], [PostCode], [HouseNumber], [AddressId]) VALUES (5, 125837, 40, 5)
INSERT [dbo].[Locations] ([Id], [PostCode], [HouseNumber], [AddressId]) VALUES (6, 125703, 49, 6)
INSERT [dbo].[Locations] ([Id], [PostCode], [HouseNumber], [AddressId]) VALUES (7, 625283, 46, 7)
INSERT [dbo].[Locations] ([Id], [PostCode], [HouseNumber], [AddressId]) VALUES (8, 614611, 50, 8)
INSERT [dbo].[Locations] ([Id], [PostCode], [HouseNumber], [AddressId]) VALUES (9, 454311, 19, 9)
INSERT [dbo].[Locations] ([Id], [PostCode], [HouseNumber], [AddressId]) VALUES (10, 660007, 19, 10)
INSERT [dbo].[Locations] ([Id], [PostCode], [HouseNumber], [AddressId]) VALUES (11, 603036, 4, 11)
INSERT [dbo].[Locations] ([Id], [PostCode], [HouseNumber], [AddressId]) VALUES (12, 450983, 26, 12)
INSERT [dbo].[Locations] ([Id], [PostCode], [HouseNumber], [AddressId]) VALUES (13, 394782, 3, 1)
INSERT [dbo].[Locations] ([Id], [PostCode], [HouseNumber], [AddressId]) VALUES (14, 603002, 28, 13)
INSERT [dbo].[Locations] ([Id], [PostCode], [HouseNumber], [AddressId]) VALUES (15, 450558, 30, 14)
INSERT [dbo].[Locations] ([Id], [PostCode], [HouseNumber], [AddressId]) VALUES (16, 394060, 43, 15)
INSERT [dbo].[Locations] ([Id], [PostCode], [HouseNumber], [AddressId]) VALUES (17, 410661, 50, 16)
INSERT [dbo].[Locations] ([Id], [PostCode], [HouseNumber], [AddressId]) VALUES (18, 625590, 20, 3)
INSERT [dbo].[Locations] ([Id], [PostCode], [HouseNumber], [AddressId]) VALUES (19, 625683, 1, 17)
INSERT [dbo].[Locations] ([Id], [PostCode], [HouseNumber], [AddressId]) VALUES (20, 400562, 32, 18)
INSERT [dbo].[Locations] ([Id], [PostCode], [HouseNumber], [AddressId]) VALUES (21, 614510, 47, 19)
INSERT [dbo].[Locations] ([Id], [PostCode], [HouseNumber], [AddressId]) VALUES (22, 410542, 46, 20)
INSERT [dbo].[Locations] ([Id], [PostCode], [HouseNumber], [AddressId]) VALUES (23, 620839, 8, 21)
INSERT [dbo].[Locations] ([Id], [PostCode], [HouseNumber], [AddressId]) VALUES (24, 443890, 1, 3)
INSERT [dbo].[Locations] ([Id], [PostCode], [HouseNumber], [AddressId]) VALUES (25, 603379, 46, 22)
INSERT [dbo].[Locations] ([Id], [PostCode], [HouseNumber], [AddressId]) VALUES (26, 603721, 41, 23)
INSERT [dbo].[Locations] ([Id], [PostCode], [HouseNumber], [AddressId]) VALUES (27, 410172, 13, 24)
INSERT [dbo].[Locations] ([Id], [PostCode], [HouseNumber], [AddressId]) VALUES (28, 420151, 32, 25)
INSERT [dbo].[Locations] ([Id], [PostCode], [HouseNumber], [AddressId]) VALUES (29, 125061, 8, 26)
INSERT [dbo].[Locations] ([Id], [PostCode], [HouseNumber], [AddressId]) VALUES (30, 630370, 24, 5)
INSERT [dbo].[Locations] ([Id], [PostCode], [HouseNumber], [AddressId]) VALUES (31, 614753, 35, 27)
INSERT [dbo].[Locations] ([Id], [PostCode], [HouseNumber], [AddressId]) VALUES (32, 426030, 44, 19)
INSERT [dbo].[Locations] ([Id], [PostCode], [HouseNumber], [AddressId]) VALUES (33, 450375, 44, 28)
INSERT [dbo].[Locations] ([Id], [PostCode], [HouseNumber], [AddressId]) VALUES (34, 625560, 12, 29)
INSERT [dbo].[Locations] ([Id], [PostCode], [HouseNumber], [AddressId]) VALUES (35, 630201, 17, 12)
INSERT [dbo].[Locations] ([Id], [PostCode], [HouseNumber], [AddressId]) VALUES (36, 190949, 26, 30)
SET IDENTITY_INSERT [dbo].[Locations] OFF
GO
SET IDENTITY_INSERT [dbo].[Manufacturers] ON 

INSERT [dbo].[Manufacturers] ([Id], [Name]) VALUES (1, N'Cat Chow')
INSERT [dbo].[Manufacturers] ([Id], [Name]) VALUES (2, N'Chappy')
INSERT [dbo].[Manufacturers] ([Id], [Name]) VALUES (3, N'Dog Chow')
INSERT [dbo].[Manufacturers] ([Id], [Name]) VALUES (4, N'Dreames')
INSERT [dbo].[Manufacturers] ([Id], [Name]) VALUES (5, N'Fancy Pets')
INSERT [dbo].[Manufacturers] ([Id], [Name]) VALUES (6, N'LIKER')
INSERT [dbo].[Manufacturers] ([Id], [Name]) VALUES (7, N'Nobby')
INSERT [dbo].[Manufacturers] ([Id], [Name]) VALUES (8, N'Pro Plan')
INSERT [dbo].[Manufacturers] ([Id], [Name]) VALUES (9, N'TitBit')
INSERT [dbo].[Manufacturers] ([Id], [Name]) VALUES (10, N'Triol')
INSERT [dbo].[Manufacturers] ([Id], [Name]) VALUES (11, N'trixie')
INSERT [dbo].[Manufacturers] ([Id], [Name]) VALUES (12, N'True Touch')
INSERT [dbo].[Manufacturers] ([Id], [Name]) VALUES (13, N'ZooM')
INSERT [dbo].[Manufacturers] ([Id], [Name]) VALUES (14, N'Kitekat')
INSERT [dbo].[Manufacturers] ([Id], [Name]) VALUES (15, N'ROYAL CANIN')
SET IDENTITY_INSERT [dbo].[Manufacturers] OFF
GO
SET IDENTITY_INSERT [dbo].[OrderProducts] ON 

INSERT [dbo].[OrderProducts] ([Id], [ProductAmount], [OrderId], [ProductId]) VALUES (1, 15, 1, N'А112Т4')
INSERT [dbo].[OrderProducts] ([Id], [ProductAmount], [OrderId], [ProductId]) VALUES (2, 1, 1, N'G453T5')
INSERT [dbo].[OrderProducts] ([Id], [ProductAmount], [OrderId], [ProductId]) VALUES (3, 15, 2, N'F432F4')
INSERT [dbo].[OrderProducts] ([Id], [ProductAmount], [OrderId], [ProductId]) VALUES (4, 15, 2, N'Y324F4')
INSERT [dbo].[OrderProducts] ([Id], [ProductAmount], [OrderId], [ProductId]) VALUES (5, 10, 3, N'E532Q5')
INSERT [dbo].[OrderProducts] ([Id], [ProductAmount], [OrderId], [ProductId]) VALUES (6, 10, 3, N'T432F4')
INSERT [dbo].[OrderProducts] ([Id], [ProductAmount], [OrderId], [ProductId]) VALUES (7, 1, 4, N'G345E4')
INSERT [dbo].[OrderProducts] ([Id], [ProductAmount], [OrderId], [ProductId]) VALUES (8, 2, 4, N'E345R4')
INSERT [dbo].[OrderProducts] ([Id], [ProductAmount], [OrderId], [ProductId]) VALUES (9, 1, 5, N'R356F4')
INSERT [dbo].[OrderProducts] ([Id], [ProductAmount], [OrderId], [ProductId]) VALUES (10, 10, 5, N'E431R5')
INSERT [dbo].[OrderProducts] ([Id], [ProductAmount], [OrderId], [ProductId]) VALUES (11, 1, 6, N'H436R4')
INSERT [dbo].[OrderProducts] ([Id], [ProductAmount], [OrderId], [ProductId]) VALUES (12, 1, 6, N'D643B5')
INSERT [dbo].[OrderProducts] ([Id], [ProductAmount], [OrderId], [ProductId]) VALUES (13, 2, 7, N'H342F5')
INSERT [dbo].[OrderProducts] ([Id], [ProductAmount], [OrderId], [ProductId]) VALUES (14, 2, 7, N'Q245F5')
INSERT [dbo].[OrderProducts] ([Id], [ProductAmount], [OrderId], [ProductId]) VALUES (15, 1, 8, N'K436T5')
INSERT [dbo].[OrderProducts] ([Id], [ProductAmount], [OrderId], [ProductId]) VALUES (16, 1, 8, N'V527T5')
INSERT [dbo].[OrderProducts] ([Id], [ProductAmount], [OrderId], [ProductId]) VALUES (17, 1, 9, N'V527T5')
INSERT [dbo].[OrderProducts] ([Id], [ProductAmount], [OrderId], [ProductId]) VALUES (18, 1, 9, N'K452T5')
INSERT [dbo].[OrderProducts] ([Id], [ProductAmount], [OrderId], [ProductId]) VALUES (19, 1, 10, N'M356R4')
INSERT [dbo].[OrderProducts] ([Id], [ProductAmount], [OrderId], [ProductId]) VALUES (20, 1, 10, N'W548O7')
SET IDENTITY_INSERT [dbo].[OrderProducts] OFF
GO
SET IDENTITY_INSERT [dbo].[Orders] ON 

INSERT [dbo].[Orders] ([Id], [Status], [OrderDate], [DeliveryDate], [LocationId], [UserId]) VALUES (1, N'Новый', CAST(N'2022-05-06T00:00:00.0000000' AS DateTime2), CAST(N'2022-05-12T00:00:00.0000000' AS DateTime2), 25, 17)
INSERT [dbo].[Orders] ([Id], [Status], [OrderDate], [DeliveryDate], [LocationId], [UserId]) VALUES (2, N'Новый', CAST(N'2022-05-06T00:00:00.0000000' AS DateTime2), CAST(N'2022-05-12T00:00:00.0000000' AS DateTime2), 20, 17)
INSERT [dbo].[Orders] ([Id], [Status], [OrderDate], [DeliveryDate], [LocationId], [UserId]) VALUES (3, N'Завершен', CAST(N'2022-05-08T00:00:00.0000000' AS DateTime2), CAST(N'2022-05-14T00:00:00.0000000' AS DateTime2), 22, 9)
INSERT [dbo].[Orders] ([Id], [Status], [OrderDate], [DeliveryDate], [LocationId], [UserId]) VALUES (4, N'Завершен', CAST(N'2022-05-08T00:00:00.0000000' AS DateTime2), CAST(N'2022-05-14T00:00:00.0000000' AS DateTime2), 24, 17)
INSERT [dbo].[Orders] ([Id], [Status], [OrderDate], [DeliveryDate], [LocationId], [UserId]) VALUES (5, N'Завершен', CAST(N'2022-05-10T00:00:00.0000000' AS DateTime2), CAST(N'2022-05-16T00:00:00.0000000' AS DateTime2), 25, 17)
INSERT [dbo].[Orders] ([Id], [Status], [OrderDate], [DeliveryDate], [LocationId], [UserId]) VALUES (6, N'Завершен', CAST(N'2022-05-11T00:00:00.0000000' AS DateTime2), CAST(N'2022-05-17T00:00:00.0000000' AS DateTime2), 28, 8)
INSERT [dbo].[Orders] ([Id], [Status], [OrderDate], [DeliveryDate], [LocationId], [UserId]) VALUES (7, N'Новый', CAST(N'2022-05-12T00:00:00.0000000' AS DateTime2), CAST(N'2022-05-18T00:00:00.0000000' AS DateTime2), 36, 17)
INSERT [dbo].[Orders] ([Id], [Status], [OrderDate], [DeliveryDate], [LocationId], [UserId]) VALUES (8, N'Новый', CAST(N'2022-05-13T00:00:00.0000000' AS DateTime2), CAST(N'2022-05-19T00:00:00.0000000' AS DateTime2), 32, 17)
INSERT [dbo].[Orders] ([Id], [Status], [OrderDate], [DeliveryDate], [LocationId], [UserId]) VALUES (9, N'Новый', CAST(N'2022-05-15T00:00:00.0000000' AS DateTime2), CAST(N'2022-05-21T00:00:00.0000000' AS DateTime2), 34, 11)
INSERT [dbo].[Orders] ([Id], [Status], [OrderDate], [DeliveryDate], [LocationId], [UserId]) VALUES (10, N'Завершен', CAST(N'2022-05-15T00:00:00.0000000' AS DateTime2), CAST(N'2022-05-21T00:00:00.0000000' AS DateTime2), 36, 10)
SET IDENTITY_INSERT [dbo].[Orders] OFF
GO
INSERT [dbo].[Products] ([Id], [Name], [Cost], [MaxDiscountAmount], [CurrentDiscountAmount], [QuantityInStock], [Description], [Photo], [ProductInfoId]) VALUES (N'B427R5', N'Миска', 400, 15, 4, 5, N'Миска для животных Triol "Стрекоза", 450 мл', NULL, 25)
INSERT [dbo].[Products] ([Id], [Name], [Cost], [MaxDiscountAmount], [CurrentDiscountAmount], [QuantityInStock], [Description], [Photo], [ProductInfoId]) VALUES (N'D356R4', N'Мячик', 600, 15, 2, 16, N'Мячик для собак TRIXIE DentaFun (32942) зеленый / белый', NULL, 27)
INSERT [dbo].[Products] ([Id], [Name], [Cost], [MaxDiscountAmount], [CurrentDiscountAmount], [QuantityInStock], [Description], [Photo], [ProductInfoId]) VALUES (N'D563F4', N'Игрушка', 600, 10, 5, 5, N'Игрушка для собак Triol Бобер 41 см 12141053 бежевый', NULL, 11)
INSERT [dbo].[Products] ([Id], [Name], [Cost], [MaxDiscountAmount], [CurrentDiscountAmount], [QuantityInStock], [Description], [Photo], [ProductInfoId]) VALUES (N'D643B5', N'Сухой корм', 4100, 30, 4, 9, N'Сухой корм для котят CAT CHOW с высоким содержанием домашней птицы', NULL, 13)
INSERT [dbo].[Products] ([Id], [Name], [Cost], [MaxDiscountAmount], [CurrentDiscountAmount], [QuantityInStock], [Description], [Photo], [ProductInfoId]) VALUES (N'E345R4', N'Игрушка', 199, 5, 5, 7, N'Игрушка для животных «Котик» с кошачьей мятой FANCY PETS', N'E345R4.jpg', 8)
INSERT [dbo].[Products] ([Id], [Name], [Cost], [MaxDiscountAmount], [CurrentDiscountAmount], [QuantityInStock], [Description], [Photo], [ProductInfoId]) VALUES (N'E431R5', N'Лакомство', 170, 5, 5, 5, N'Лакомство для собак Triol Кость из жил 7.5 см, 4шт. в уп.', N'E431R5.png', 10)
INSERT [dbo].[Products] ([Id], [Name], [Cost], [MaxDiscountAmount], [CurrentDiscountAmount], [QuantityInStock], [Description], [Photo], [ProductInfoId]) VALUES (N'E434U6', N'Лакомство', 140, 20, 3, 19, N'Лакомство для собак Titbit Лакомый кусочек Нарезка из говядины, 80 г', NULL, 28)
INSERT [dbo].[Products] ([Id], [Name], [Cost], [MaxDiscountAmount], [CurrentDiscountAmount], [QuantityInStock], [Description], [Photo], [ProductInfoId]) VALUES (N'E466T6', N'Клетка', 3500, 30, 5, 3, N'Клетка для собак Triol 30671002 61х45.5х52 см серый/белый', NULL, 24)
INSERT [dbo].[Products] ([Id], [Name], [Cost], [MaxDiscountAmount], [CurrentDiscountAmount], [QuantityInStock], [Description], [Photo], [ProductInfoId]) VALUES (N'E532Q5', N'Лакомство', 166, 15, 5, 18, N'Лакомство для собак Titbit Печенье Био Десерт с лососем стандарт, 350 г', N'E532Q5.jpg', 5)
INSERT [dbo].[Products] ([Id], [Name], [Cost], [MaxDiscountAmount], [CurrentDiscountAmount], [QuantityInStock], [Description], [Photo], [ProductInfoId]) VALUES (N'EE1266', N'Сухой корм', 379.11, 25, 10, 27, N'Питательный корм на каждый день. Такой обед всегда вдохновляет энергичных котов на увлекательные игры.

Ведь KitekatTM — это полноценная еда, которая содержит все необходимое для вашей кошки. KitekatTM приготовлен из таких же качественных продуктов, которые вы используете дома для своих близких: мясные ингредиенты, овощи, растительное масло и крупы. KitekatTM знает, как их правильно сбалансировать для энергии и здоровья вашего кота.', NULL, 1008)
INSERT [dbo].[Products] ([Id], [Name], [Cost], [MaxDiscountAmount], [CurrentDiscountAmount], [QuantityInStock], [Description], [Photo], [ProductInfoId]) VALUES (N'F432F4', N'Сухой корм', 1200, 10, 3, 15, N'Сухой корм для кошек Pro Plan с чувствительным пищеварением', N'F432F4.jpg', 3)
INSERT [dbo].[Products] ([Id], [Name], [Cost], [MaxDiscountAmount], [CurrentDiscountAmount], [QuantityInStock], [Description], [Photo], [ProductInfoId]) VALUES (N'G345E4', N'Мячик', 300, 5, 3, 19, N'Мячик для собак LIKER Мячик Лайкер (6294) оранжевый', N'G345E4.jpg', 7)
INSERT [dbo].[Products] ([Id], [Name], [Cost], [MaxDiscountAmount], [CurrentDiscountAmount], [QuantityInStock], [Description], [Photo], [ProductInfoId]) VALUES (N'G453T5', N'Щетка-варежка', 149, 15, 2, 7, N'Щетка-варежка True Touch для вычесывания шерсти, синий', N'G453T5.jpg', 2)
INSERT [dbo].[Products] ([Id], [Name], [Cost], [MaxDiscountAmount], [CurrentDiscountAmount], [QuantityInStock], [Description], [Photo], [ProductInfoId]) VALUES (N'G542F5', N'Сухой корм', 2190, 30, 4, 7, N'Сухой корм для собак Pro Plan при чувствительном пищеварении, ягненок', NULL, 19)
INSERT [dbo].[Products] ([Id], [Name], [Cost], [MaxDiscountAmount], [CurrentDiscountAmount], [QuantityInStock], [Description], [Photo], [ProductInfoId]) VALUES (N'H342F5', N'Игрушка', 510, 5, 2, 17, N'Игрушка для собак Triol Енот 41 см 12141063 серый', NULL, 17)
INSERT [dbo].[Products] ([Id], [Name], [Cost], [MaxDiscountAmount], [CurrentDiscountAmount], [QuantityInStock], [Description], [Photo], [ProductInfoId]) VALUES (N'H432F4', N'Миска', 385, 10, 2, 17, N'Миска Triol 9002/KIDP3211/30261087 400 мл серебристый', NULL, 14)
INSERT [dbo].[Products] ([Id], [Name], [Cost], [MaxDiscountAmount], [CurrentDiscountAmount], [QuantityInStock], [Description], [Photo], [ProductInfoId]) VALUES (N'H436R4', N'Игрушка', 300, 15, 2, 15, N'Игрушка для собак Triol 3D плетение EC-04/12171005 бежевый', NULL, 12)
INSERT [dbo].[Products] ([Id], [Name], [Cost], [MaxDiscountAmount], [CurrentDiscountAmount], [QuantityInStock], [Description], [Photo], [ProductInfoId]) VALUES (N'H542R6', N'Лакомство', 177, 15, 3, 15, N'Лакомство для собак Triol Мясные полоски из кролика, 70 г', NULL, 20)
INSERT [dbo].[Products] ([Id], [Name], [Cost], [MaxDiscountAmount], [CurrentDiscountAmount], [QuantityInStock], [Description], [Photo], [ProductInfoId]) VALUES (N'H643W2', N'Миска', 292, 25, 3, 13, N'Миска Triol CB02/30231002 100 мл бежевый/голубой', NULL, 26)
INSERT [dbo].[Products] ([Id], [Name], [Cost], [MaxDiscountAmount], [CurrentDiscountAmount], [QuantityInStock], [Description], [Photo], [ProductInfoId]) VALUES (N'K436T5', N'Мячик', 100, 5, 4, 21, N'Мячик для собак Triol с косточками 12101096 желтый/зеленый', NULL, 21)
INSERT [dbo].[Products] ([Id], [Name], [Cost], [MaxDiscountAmount], [CurrentDiscountAmount], [QuantityInStock], [Description], [Photo], [ProductInfoId]) VALUES (N'K452T5', N'Лежак', 800, 25, 2, 17, N'Лежак для собак и кошек ZooM Lama 40х30х8 см бежевый', NULL, 23)
INSERT [dbo].[Products] ([Id], [Name], [Cost], [MaxDiscountAmount], [CurrentDiscountAmount], [QuantityInStock], [Description], [Photo], [ProductInfoId]) VALUES (N'M356R4', N'Лакомство', 50, 5, 4, 6, N'Лакомство для собак Titbit Гематоген мясной Classic, 35 г', NULL, 29)
INSERT [dbo].[Products] ([Id], [Name], [Cost], [MaxDiscountAmount], [CurrentDiscountAmount], [QuantityInStock], [Description], [Photo], [ProductInfoId]) VALUES (N'Q245F5', N'Игрушка', 510, 5, 2, 17, N'Игрушка для собак Triol Бобер 41 см 12141063 серый', NULL, 18)
INSERT [dbo].[Products] ([Id], [Name], [Cost], [MaxDiscountAmount], [CurrentDiscountAmount], [QuantityInStock], [Description], [Photo], [ProductInfoId]) VALUES (N'R356F4', N'Миска', 234, 10, 3, 17, N'Миска Nobby с рисунком Dog для собак 130 мл красный', N'R356F4.jpg', 9)
INSERT [dbo].[Products] ([Id], [Name], [Cost], [MaxDiscountAmount], [CurrentDiscountAmount], [QuantityInStock], [Description], [Photo], [ProductInfoId]) VALUES (N'S245R4', N'Сухой корм', 280, 15, 3, 8, N'Сухой корм для кошек CAT CHOW', NULL, 15)
INSERT [dbo].[Products] ([Id], [Name], [Cost], [MaxDiscountAmount], [CurrentDiscountAmount], [QuantityInStock], [Description], [Photo], [ProductInfoId]) VALUES (N'T432F4', N'Сухой корм', 1700, 25, 2, 5, N'Сухой корм для собак Chappi говядина по-домашнему, с овощами', N'T432F4.jpg', 6)
INSERT [dbo].[Products] ([Id], [Name], [Cost], [MaxDiscountAmount], [CurrentDiscountAmount], [QuantityInStock], [Description], [Photo], [ProductInfoId]) VALUES (N'V352R4', N'Сухой корм', 1700, 25, 4, 9, N'Сухой корм для собак Chappi Мясное изобилие, мясное ассорти', NULL, 16)
INSERT [dbo].[Products] ([Id], [Name], [Cost], [MaxDiscountAmount], [CurrentDiscountAmount], [QuantityInStock], [Description], [Photo], [ProductInfoId]) VALUES (N'V527T5', N'Игрушка', 640, 5, 5, 4, N'Игрушка для собак Triol Ящерица 39 см коричневый', NULL, 22)
INSERT [dbo].[Products] ([Id], [Name], [Cost], [MaxDiscountAmount], [CurrentDiscountAmount], [QuantityInStock], [Description], [Photo], [ProductInfoId]) VALUES (N'W548O7', N'Сухой корм', 600, 15, 5, 15, N'Сухой корм для щенков DOG CHOW Puppy, ягненок 2.5 кг', NULL, 30)
INSERT [dbo].[Products] ([Id], [Name], [Cost], [MaxDiscountAmount], [CurrentDiscountAmount], [QuantityInStock], [Description], [Photo], [ProductInfoId]) VALUES (N'Y324F4', N'Лакомство', 86, 5, 4, 17, N'Лакомство для собак Titbit Косточки мясные с индейкой и ягненком, 145 г', N'Y324F4.jpg', 4)
INSERT [dbo].[Products] ([Id], [Name], [Cost], [MaxDiscountAmount], [CurrentDiscountAmount], [QuantityInStock], [Description], [Photo], [ProductInfoId]) VALUES (N'А112Т4', N'Лакомство', 123, 30, 3, 6, N'Лакомство для кошек Dreamies Подушечки с курицей, 140 г', N'А112Т4.png', 1)
GO
SET IDENTITY_INSERT [dbo].[ProductsInfo] ON 

INSERT [dbo].[ProductsInfo] ([Id], [CategoryId], [ManufacturerId], [SupplierId]) VALUES (1, 2, 4, 1)
INSERT [dbo].[ProductsInfo] ([Id], [CategoryId], [ManufacturerId], [SupplierId]) VALUES (2, 1, 12, 2)
INSERT [dbo].[ProductsInfo] ([Id], [CategoryId], [ManufacturerId], [SupplierId]) VALUES (3, 2, 8, 2)
INSERT [dbo].[ProductsInfo] ([Id], [CategoryId], [ManufacturerId], [SupplierId]) VALUES (4, 3, 9, 1)
INSERT [dbo].[ProductsInfo] ([Id], [CategoryId], [ManufacturerId], [SupplierId]) VALUES (5, 3, 9, 1)
INSERT [dbo].[ProductsInfo] ([Id], [CategoryId], [ManufacturerId], [SupplierId]) VALUES (6, 3, 2, 2)
INSERT [dbo].[ProductsInfo] ([Id], [CategoryId], [ManufacturerId], [SupplierId]) VALUES (7, 3, 6, 2)
INSERT [dbo].[ProductsInfo] ([Id], [CategoryId], [ManufacturerId], [SupplierId]) VALUES (8, 2, 5, 2)
INSERT [dbo].[ProductsInfo] ([Id], [CategoryId], [ManufacturerId], [SupplierId]) VALUES (9, 3, 7, 1)
INSERT [dbo].[ProductsInfo] ([Id], [CategoryId], [ManufacturerId], [SupplierId]) VALUES (10, 3, 10, 2)
INSERT [dbo].[ProductsInfo] ([Id], [CategoryId], [ManufacturerId], [SupplierId]) VALUES (11, 3, 10, 1)
INSERT [dbo].[ProductsInfo] ([Id], [CategoryId], [ManufacturerId], [SupplierId]) VALUES (12, 3, 10, 1)
INSERT [dbo].[ProductsInfo] ([Id], [CategoryId], [ManufacturerId], [SupplierId]) VALUES (13, 2, 1, 1)
INSERT [dbo].[ProductsInfo] ([Id], [CategoryId], [ManufacturerId], [SupplierId]) VALUES (14, 1, 10, 2)
INSERT [dbo].[ProductsInfo] ([Id], [CategoryId], [ManufacturerId], [SupplierId]) VALUES (15, 2, 1, 2)
INSERT [dbo].[ProductsInfo] ([Id], [CategoryId], [ManufacturerId], [SupplierId]) VALUES (16, 3, 2, 1)
INSERT [dbo].[ProductsInfo] ([Id], [CategoryId], [ManufacturerId], [SupplierId]) VALUES (17, 3, 10, 2)
INSERT [dbo].[ProductsInfo] ([Id], [CategoryId], [ManufacturerId], [SupplierId]) VALUES (18, 3, 10, 2)
INSERT [dbo].[ProductsInfo] ([Id], [CategoryId], [ManufacturerId], [SupplierId]) VALUES (19, 3, 8, 1)
INSERT [dbo].[ProductsInfo] ([Id], [CategoryId], [ManufacturerId], [SupplierId]) VALUES (20, 3, 10, 2)
INSERT [dbo].[ProductsInfo] ([Id], [CategoryId], [ManufacturerId], [SupplierId]) VALUES (21, 3, 10, 2)
INSERT [dbo].[ProductsInfo] ([Id], [CategoryId], [ManufacturerId], [SupplierId]) VALUES (22, 3, 10, 1)
INSERT [dbo].[ProductsInfo] ([Id], [CategoryId], [ManufacturerId], [SupplierId]) VALUES (23, 3, 13, 2)
INSERT [dbo].[ProductsInfo] ([Id], [CategoryId], [ManufacturerId], [SupplierId]) VALUES (24, 3, 10, 2)
INSERT [dbo].[ProductsInfo] ([Id], [CategoryId], [ManufacturerId], [SupplierId]) VALUES (25, 1, 10, 2)
INSERT [dbo].[ProductsInfo] ([Id], [CategoryId], [ManufacturerId], [SupplierId]) VALUES (26, 1, 10, 1)
INSERT [dbo].[ProductsInfo] ([Id], [CategoryId], [ManufacturerId], [SupplierId]) VALUES (27, 3, 11, 1)
INSERT [dbo].[ProductsInfo] ([Id], [CategoryId], [ManufacturerId], [SupplierId]) VALUES (28, 3, 9, 2)
INSERT [dbo].[ProductsInfo] ([Id], [CategoryId], [ManufacturerId], [SupplierId]) VALUES (29, 3, 9, 2)
INSERT [dbo].[ProductsInfo] ([Id], [CategoryId], [ManufacturerId], [SupplierId]) VALUES (30, 3, 3, 1)
INSERT [dbo].[ProductsInfo] ([Id], [CategoryId], [ManufacturerId], [SupplierId]) VALUES (31, 2, 14, 2)
INSERT [dbo].[ProductsInfo] ([Id], [CategoryId], [ManufacturerId], [SupplierId]) VALUES (32, 2, 2, 1)
INSERT [dbo].[ProductsInfo] ([Id], [CategoryId], [ManufacturerId], [SupplierId]) VALUES (33, 2, 14, 1)
INSERT [dbo].[ProductsInfo] ([Id], [CategoryId], [ManufacturerId], [SupplierId]) VALUES (1008, 2, 14, 1)
SET IDENTITY_INSERT [dbo].[ProductsInfo] OFF
GO
SET IDENTITY_INSERT [dbo].[Roles] ON 

INSERT [dbo].[Roles] ([Id], [Name]) VALUES (1, N'Администратор')
INSERT [dbo].[Roles] ([Id], [Name]) VALUES (2, N'Клиент')
INSERT [dbo].[Roles] ([Id], [Name]) VALUES (3, N'Менеджер')
INSERT [dbo].[Roles] ([Id], [Name]) VALUES (4, N'Гость')
SET IDENTITY_INSERT [dbo].[Roles] OFF
GO
SET IDENTITY_INSERT [dbo].[Suppliers] ON 

INSERT [dbo].[Suppliers] ([Id], [Name]) VALUES (1, N'PetShop')
INSERT [dbo].[Suppliers] ([Id], [Name]) VALUES (2, N'ZooMir')
INSERT [dbo].[Suppliers] ([Id], [Name]) VALUES (1002, N'ZooZavr')
SET IDENTITY_INSERT [dbo].[Suppliers] OFF
GO
SET IDENTITY_INSERT [dbo].[Users] ON 

INSERT [dbo].[Users] ([Id], [Name], [Surname], [Patronymic], [Login], [Password], [RoleId]) VALUES (1, N'Илья', N'Суслов', N'Арсентьевич', N'pixil59@gmail.com', N'2L6KZG', 1)
INSERT [dbo].[Users] ([Id], [Name], [Surname], [Patronymic], [Login], [Password], [RoleId]) VALUES (4, N'Алина', N'Игнатьева', N'Михайловна', N'vilagajaunne-5170@yandex.ru', N'8ntwUp', 1)
INSERT [dbo].[Users] ([Id], [Name], [Surname], [Patronymic], [Login], [Password], [RoleId]) VALUES (5, N'Михаил', N'Денисов', N'Романович', N'frusubroppotou656@yandex.ru', N'YOyhfR', 3)
INSERT [dbo].[Users] ([Id], [Name], [Surname], [Patronymic], [Login], [Password], [RoleId]) VALUES (6, N'Михаил', N'Тимофеев', N'Елисеевич', N'leuttevitrafo1998@mail.ru', N'RSbvHv', 3)
INSERT [dbo].[Users] ([Id], [Name], [Surname], [Patronymic], [Login], [Password], [RoleId]) VALUES (7, N'Ярослав', N'Соловьев', N'Маркович', N'frapreubrulloba1141@yandex.ru', N'rwVDh9', 3)
INSERT [dbo].[Users] ([Id], [Name], [Surname], [Patronymic], [Login], [Password], [RoleId]) VALUES (8, N'Роберт', N'Филимонов', N'Васильевич', N'loudittoimmolau1900@gmail.com', N'LdNyos', 2)
INSERT [dbo].[Users] ([Id], [Name], [Surname], [Patronymic], [Login], [Password], [RoleId]) VALUES (9, N'Майя', N'Шилова', N'Артемьевна', N'hittuprofassa4984@mail.com', N'gynQMT', 2)
INSERT [dbo].[Users] ([Id], [Name], [Surname], [Patronymic], [Login], [Password], [RoleId]) VALUES (10, N'Виктория', N'Чистякова', N'Степановна', N'freineiciweijau888@yandex.ru', N'AtnDjr', 2)
INSERT [dbo].[Users] ([Id], [Name], [Surname], [Patronymic], [Login], [Password], [RoleId]) VALUES (11, N'Эмилия', N'Волкова', N'Артёмовна', N'nokupekidda2001@gmail.com', N'JlFRCZ', 2)
INSERT [dbo].[Users] ([Id], [Name], [Surname], [Patronymic], [Login], [Password], [RoleId]) VALUES (16, N'Ярослава', N'Яковлева', N'Даниэльевна', N'deummecillummu-4992@mail.ru', N'uzWC67', 1)
INSERT [dbo].[Users] ([Id], [Name], [Surname], [Patronymic], [Login], [Password], [RoleId]) VALUES (17, N'Иван', N'Иванов', N'Иванович', N'guest@gmail.com', N'Qwert12345', 4)
SET IDENTITY_INSERT [dbo].[Users] OFF
GO
ALTER TABLE [dbo].[Orders] ADD  DEFAULT ((0)) FOR [UserId]
GO
ALTER TABLE [dbo].[GrocerySets]  WITH CHECK ADD  CONSTRAINT [FK_GrocerySets_Products_ProductId] FOREIGN KEY([ProductId])
REFERENCES [dbo].[Products] ([Id])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[GrocerySets] CHECK CONSTRAINT [FK_GrocerySets_Products_ProductId]
GO
ALTER TABLE [dbo].[GrocerySets]  WITH CHECK ADD  CONSTRAINT [FK_GrocerySets_SubProducts_SubProductId] FOREIGN KEY([SubProductId])
REFERENCES [dbo].[SubProducts] ([Id])
GO
ALTER TABLE [dbo].[GrocerySets] CHECK CONSTRAINT [FK_GrocerySets_SubProducts_SubProductId]
GO
ALTER TABLE [dbo].[Locations]  WITH CHECK ADD  CONSTRAINT [FK_Locations_Addresses_AddressId] FOREIGN KEY([AddressId])
REFERENCES [dbo].[Addresses] ([Id])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[Locations] CHECK CONSTRAINT [FK_Locations_Addresses_AddressId]
GO
ALTER TABLE [dbo].[Mixtures]  WITH CHECK ADD  CONSTRAINT [FK_Mixtures_BaseMaterials_BaseMaterialId] FOREIGN KEY([BaseMaterialId])
REFERENCES [dbo].[BaseMaterials] ([Id])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[Mixtures] CHECK CONSTRAINT [FK_Mixtures_BaseMaterials_BaseMaterialId]
GO
ALTER TABLE [dbo].[Mixtures]  WITH CHECK ADD  CONSTRAINT [FK_Mixtures_RawMaterials_RawMaterialId] FOREIGN KEY([RawMaterialId])
REFERENCES [dbo].[RawMaterials] ([Id])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[Mixtures] CHECK CONSTRAINT [FK_Mixtures_RawMaterials_RawMaterialId]
GO
ALTER TABLE [dbo].[OrderProducts]  WITH CHECK ADD  CONSTRAINT [FK_OrderProducts_Orders_OrderId] FOREIGN KEY([OrderId])
REFERENCES [dbo].[Orders] ([Id])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[OrderProducts] CHECK CONSTRAINT [FK_OrderProducts_Orders_OrderId]
GO
ALTER TABLE [dbo].[OrderProducts]  WITH CHECK ADD  CONSTRAINT [FK_OrderProducts_Products_ProductId] FOREIGN KEY([ProductId])
REFERENCES [dbo].[Products] ([Id])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[OrderProducts] CHECK CONSTRAINT [FK_OrderProducts_Products_ProductId]
GO
ALTER TABLE [dbo].[Orders]  WITH CHECK ADD  CONSTRAINT [FK_Orders_Locations_LocationId] FOREIGN KEY([LocationId])
REFERENCES [dbo].[Locations] ([Id])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[Orders] CHECK CONSTRAINT [FK_Orders_Locations_LocationId]
GO
ALTER TABLE [dbo].[Orders]  WITH CHECK ADD  CONSTRAINT [FK_Orders_Users_UserId] FOREIGN KEY([UserId])
REFERENCES [dbo].[Users] ([Id])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[Orders] CHECK CONSTRAINT [FK_Orders_Users_UserId]
GO
ALTER TABLE [dbo].[Products]  WITH CHECK ADD  CONSTRAINT [FK_Products_ProductsInfo_ProductInfoId] FOREIGN KEY([ProductInfoId])
REFERENCES [dbo].[ProductsInfo] ([Id])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[Products] CHECK CONSTRAINT [FK_Products_ProductsInfo_ProductInfoId]
GO
ALTER TABLE [dbo].[ProductsInfo]  WITH CHECK ADD  CONSTRAINT [FK_ProductsInfo_Categories_CategoryId] FOREIGN KEY([CategoryId])
REFERENCES [dbo].[Categories] ([Id])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[ProductsInfo] CHECK CONSTRAINT [FK_ProductsInfo_Categories_CategoryId]
GO
ALTER TABLE [dbo].[ProductsInfo]  WITH CHECK ADD  CONSTRAINT [FK_ProductsInfo_Manufacturers_ManufacturerId] FOREIGN KEY([ManufacturerId])
REFERENCES [dbo].[Manufacturers] ([Id])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[ProductsInfo] CHECK CONSTRAINT [FK_ProductsInfo_Manufacturers_ManufacturerId]
GO
ALTER TABLE [dbo].[ProductsInfo]  WITH CHECK ADD  CONSTRAINT [FK_ProductsInfo_Suppliers_SupplierId] FOREIGN KEY([SupplierId])
REFERENCES [dbo].[Suppliers] ([Id])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[ProductsInfo] CHECK CONSTRAINT [FK_ProductsInfo_Suppliers_SupplierId]
GO
ALTER TABLE [dbo].[SubProducts]  WITH CHECK ADD  CONSTRAINT [FK_SubProducts_BaseMaterials_BaseMaterialId] FOREIGN KEY([BaseMaterialId])
REFERENCES [dbo].[BaseMaterials] ([Id])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[SubProducts] CHECK CONSTRAINT [FK_SubProducts_BaseMaterials_BaseMaterialId]
GO
ALTER TABLE [dbo].[SubProducts]  WITH CHECK ADD  CONSTRAINT [FK_SubProducts_ProductsInfo_ProductInfoId] FOREIGN KEY([ProductInfoId])
REFERENCES [dbo].[ProductsInfo] ([Id])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[SubProducts] CHECK CONSTRAINT [FK_SubProducts_ProductsInfo_ProductInfoId]
GO
ALTER TABLE [dbo].[Users]  WITH CHECK ADD  CONSTRAINT [FK_Users_Roles_RoleId] FOREIGN KEY([RoleId])
REFERENCES [dbo].[Roles] ([Id])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[Users] CHECK CONSTRAINT [FK_Users_Roles_RoleId]
GO

using Blogg.Migrations;
using Blogg.Models;
using Microsoft.Owin;
using Owin;
using System.Data.Entity;

[assembly: OwinStartupAttribute(typeof(Blogg.Startup))]
namespace Blogg
{
    public partial class Startup
    {
        public void Configuration(IAppBuilder app)
        {
            Database.SetInitializer(
                new MigrateDatabaseToLatestVersion<
                    BlogDbContext,
                    Configuration>());

            ConfigureAuth(app);
        }
    }
}

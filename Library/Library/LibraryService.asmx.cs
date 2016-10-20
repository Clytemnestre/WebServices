using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Web;
using System.Web.Services;

namespace Library
{
    /// <summary>
    /// Summary description for LibraryService
    /// </summary>
    [WebService(Namespace = "http://tempuri.org/")]
    [WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]
    [System.ComponentModel.ToolboxItem(false)]
    // To allow this Web Service to be called from script, using ASP.NET AJAX, uncomment the following line. 
    // [System.Web.Script.Services.ScriptService]
    public class LibraryService : System.Web.Services.WebService
    {


        [WebMethod]
        int AddBook(string title, string author, int yop)
        {
            String book = title + ";" + author + ";" + yop;

            using (StreamWriter writetext = new StreamWriter("write.txt"))
            {
                writetext.WriteLine(book);
            }

            return 0;
        }

        /*[WebMethod]
        List<string> getFilteredBooks(String keyword)
        {
        
        }*/
    }
}

using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Web;
using System.Web.Services;

namespace RemoteLibrary
{
    /// <summary>
    /// Summary description for RemoteLibService
    /// </summary>
    [WebService(Namespace = "http://tempuri.org/")]
    [WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]
    [System.ComponentModel.ToolboxItem(false)]
    // To allow this Web Service to be called from script, using ASP.NET AJAX, uncomment the following line. 
    // [System.Web.Script.Services.ScriptService]
    public class RemoteLibService : System.Web.Services.WebService
    {

        private static readonly String FILE_NAME = @"C:\Users\ipd\Documents\WebServices\RemoteLibrary\RemoteLibrary\data.txt";
        [WebMethod]
        public void AddBook(string title, string author, int yop)
        {
            Console.WriteLine("AddBook() called");
            String book = string.Format("{0};{1};{2}", title, author, yop);
            try
            {
                File.AppendAllText(FILE_NAME, book + Environment.NewLine);
            }
            catch (IOException e)
            {
                Console.WriteLine(e);
                Console.ReadKey();
                throw e;
            }
        }

        [WebMethod]
        public List<string> GetFilteredBooks(string keyword)
        {
            Console.WriteLine("GetFilteredBooks() called");
            try
            {
                String[] lines = File.ReadAllLines(FILE_NAME);                
                List<string> bookList = new List<string>();
                foreach (var book in lines)
                {
                    if (book.Contains(keyword))
                    {
                        bookList.Add(book);
                    }
                }
                return bookList;
            }
            catch (IOException e)
            {
                Console.WriteLine(e);
                Console.ReadKey();
                throw e;
            }
        }
    }
}

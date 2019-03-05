package com.tucanoo.mep.tests.pages

import geb.Page

class MontagueLoginPage extends Page {
  static url = 'montagues/auth'
  static at = { title == 'Montague Login' }
}
